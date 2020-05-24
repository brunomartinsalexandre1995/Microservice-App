package com.microservices.hotels.service;

import com.microservices.hotels.dto.HotelSearchDTO;
import com.microservices.hotels.dto.HotelSearchSuggestionDTO;
import com.microservices.hotels.repository.HotelRequest;
import com.microservices.hotels.repository.HotelRequestRepository;
import com.microservices.hotels.repository.HotelSuggestion;
import com.microservices.hotels.repository.HotelSuggestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class HotelsService {


    HotelRequestRepository hotelRequestRepository;

    private static final String IMDB_API_BASE_URL = "https://hotels4.p.rapidapi.com/locations/search";
    private static final String API_HOST_HEADER_NAME = "X-RapidAPI-Host";
    private static final String API_HOST_HEADER_VALUE = "hotels4.p.rapidapi.com";
    private static final String API_KEY_HEADER_NAME = "X-RapidAPI-Key";
    private static final String API_KEY_HEADER_VALUE = "afc0ab2d40msh6bf8d332e564cf1p1798b7jsn9c9bd860d66f";
    private static final String USER_AGENT_NAME = "user-agent";
    private static final String USER_AGENT_VALUE = "Mozilla/5.0 Firefox/26.0";

    private RestTemplateBuilder restTemplateBuilder;

    public HotelSearchDTO searchRequest(String query) {
        HttpEntity requestEntity = createHttpRequestEntity();
        ResponseEntity<HotelSearchDTO> response = restTemplateBuilder.build().exchange(
                IMDB_API_BASE_URL + "?query=" + query,
                HttpMethod.GET,
                requestEntity,
                HotelSearchDTO.class,
                0);
        HotelSearchDTO responseModel = response.getBody();
        saveRequestDataInDatabase(query, responseModel);
        return responseModel;
    }

    private HttpEntity createHttpRequestEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(API_HOST_HEADER_NAME, API_HOST_HEADER_VALUE);
        headers.set(API_KEY_HEADER_NAME, API_KEY_HEADER_VALUE);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(USER_AGENT_NAME, USER_AGENT_VALUE);
        return new HttpEntity(headers);
    }

    private void saveRequestDataInDatabase(String content, HotelSearchDTO responseModel) {
        HotelRequest dataToSave = new HotelRequest();
        dataToSave.setSearchWord(content);
        dataToSave.setAutoSuggestInstance(responseModel.getAutoSuggestInstance());
        dataToSave.setMisspellingfallback(responseModel.getMisspellingfallback());
        dataToSave.setMoresuggestions(responseModel.getMoresuggestions());
        dataToSave.setTrackingID(responseModel.getTrackingID());

        List<HotelSuggestion> suggestionsToSave = new ArrayList<>();
        for (HotelSearchSuggestionDTO suggestion : responseModel.getSuggestions()) {
            HotelSuggestion sData = new HotelSuggestion();
            sData.setSuggestionGroup(suggestion.getGroup());
            List<HotelSuggestionEntity> entitiesToSave = new ArrayList<>();
            suggestion.getEntities().forEach( entity -> {
                HotelSuggestionEntity eData = new HotelSuggestionEntity();
                eData.setCaption(entity.getCaption());
                eData.setDestinationId(entity.getDestinationId());
                eData.setGeoId(entity.getGeoId());
                eData.setLandmarkCityDestinationId(entity.getLandmarkCityDestinationId());
                eData.setLatitude(entity.getLatitude());
                eData.setLongitude(entity.getLongitude());
                eData.setName(entity.getName());
                eData.setRedirectPage(entity.getRedirectPage());
                eData.setType(entity.getType());
                entitiesToSave.add(eData);
            });
            sData.setEntities(entitiesToSave);
            suggestionsToSave.add(sData);
        }

        dataToSave.setSuggestions(suggestionsToSave);
        hotelRequestRepository.save(dataToSave);
    }

    @Autowired
    public void setRestTemplateBuilder(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Autowired
    public void setHotelRequestRepository(HotelRequestRepository hotelRequestRepository) {
        this.hotelRequestRepository = hotelRequestRepository;
    }


}
