package com.microservice.cinema.service;

import com.microservice.cinema.model.IMBDResponseDTO;
import com.microservice.cinema.event.SearchRequestEvent;
import com.microservice.cinema.event.RabbitSearchRequestEventDispatcher;
import com.microservice.cinema.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class IMDBApiService {

    private static final String IMDB_API_BASE_URL = "https://imdb-internet-movie-database-unofficial.p.rapidapi.com/search/";
    private static final String API_HOST_HEADER_NAME = "X-RapidAPI-Host";
    private static final String API_HOST_HEADER_VALUE = "imdb-internet-movie-database-unofficial.p.rapidapi.com";
    private static final String API_KEY_HEADER_NAME = "X-RapidAPI-Key";
    private static final String API_KEY_HEADER_VALUE = "afc0ab2d40msh6bf8d332e564cf1p1798b7jsn9c9bd860d66f";
    private static final String USER_AGENT_NAME = "user-agent";
    private static final String USER_AGENT_VALUE = "Mozilla/5.0 Firefox/26.0";

    private RestTemplateBuilder restTemplateBuilder;
    private IMDBRequestRepository imdbRequestRepository;


    private RabbitSearchRequestEventDispatcher rabbitSearchRequestEventDispatcher;

    public IMBDResponseDTO searchRequest(String content) {
        HttpEntity requestEntity = createHttpRequestEntity();
        ResponseEntity<IMBDResponseDTO> response = restTemplateBuilder.build().exchange(
                IMDB_API_BASE_URL + content,
                HttpMethod.GET,
                requestEntity,
                IMBDResponseDTO.class,
                0);
        IMBDResponseDTO responseModel = response.getBody();
        saveRequestDataInDatabase(content, responseModel);
        rabbitSearchRequestEventDispatcher.send(new SearchRequestEvent(UUID.randomUUID().toString(), content, "MovieApp"));
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

    private void saveRequestDataInDatabase(String content, IMBDResponseDTO responseModel) {
        IMDBRequest request = new IMDBRequest();
        request.setSearchWord(content);
        List<IMDBMovie> movies = new ArrayList<>();
        responseModel.titles.forEach(title -> {
            IMDBMovie movie = new IMDBMovie();
            movie.setImage(title.image);
            movie.setImdbID(title.id);
            movie.setTitle(title.title);
            movies.add(movie);
        });

        List<IMDBName> names = new ArrayList<>();
        responseModel.names.forEach(title -> {
            IMDBName name = new IMDBName();
            name.setImage(title.image);
            name.setImdbID(title.id);
            name.setTitle(title.title);
            names.add(name);
        });

        List<IMDBCompany> companies = new ArrayList<>();
        responseModel.companies.forEach(title -> {
            IMDBCompany company = new IMDBCompany();
            company.setImage(title.image);
            company.setImdbID(title.id);
            company.setTitle(title.title);
            companies.add(company);
        });

        request.setMovies(movies);
        request.setNames(names);
        request.setCompanies(companies);

        imdbRequestRepository.save(request);
    }

    @Autowired
    public void setRabbitSearchRequestEventDispatcher(RabbitSearchRequestEventDispatcher rabbitSearchRequestEventDispatcher) {
        this.rabbitSearchRequestEventDispatcher = rabbitSearchRequestEventDispatcher;
    }

    @Autowired
    public void setRestTemplateBuilder(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Autowired
    public void setImdbRequestRepository(IMDBRequestRepository imdbRequestRepository) {
        this.imdbRequestRepository = imdbRequestRepository;
    }

}
