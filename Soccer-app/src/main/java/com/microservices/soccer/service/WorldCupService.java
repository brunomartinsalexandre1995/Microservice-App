package com.microservices.soccer.service;


import com.microservices.soccer.controller.WorldCupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class WorldCupService {

    private static final String IMDB_API_BASE_URL = "https://stroccoli-futbol-science-v1.p.rapidapi.com/world_cup/results/";
    private static final String API_HOST_HEADER_NAME = "X-RapidAPI-Host";
    private static final String API_HOST_HEADER_VALUE = "stroccoli-futbol-science-v1.p.rapidapi.com";
    private static final String API_KEY_HEADER_NAME = "X-RapidAPI-Key";
    private static final String API_KEY_HEADER_VALUE = "afc0ab2d40msh6bf8d332e564cf1p1798b7jsn9c9bd860d66f";
    private static final String USER_AGENT_NAME = "user-agent";
    private static final String USER_AGENT_VALUE = "Mozilla/5.0 Firefox/26.0";

    private RestTemplateBuilder restTemplateBuilder;


    public WorldCupResponseDTO searchRequest(String year) {
        HttpEntity requestEntity = createHttpRequestEntity();
        ResponseEntity<WorldCupResponseDTO> response = restTemplateBuilder.build().exchange(
                IMDB_API_BASE_URL + year,
                HttpMethod.GET,
                requestEntity,
                WorldCupResponseDTO.class,
                0);

        WorldCupResponseDTO responseModel = response.getBody();

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

    @Autowired
    public void setRestTemplateBuilder(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


}
