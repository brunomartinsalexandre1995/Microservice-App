package com.arcade.platform.service.api;

import com.arcade.platform.controller.imdb.IMBDResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class IMDBApiService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public IMBDResponseDTO search(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://imdb-internet-movie-database-unofficial.p.rapidapi.com/search/inception";

        HttpHeaders headers = new HttpHeaders();
       //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set custom header
        headers.set("X-RapidAPI-Host", "imdb-internet-movie-database-unofficial.p.rapidapi.com");
        headers.set("X-RapidAPI-Key", "afc0ab2d40msh6bf8d332e564cf1p1798b7jsn9c9bd860d66f");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent", "Mozilla/5.0 Firefox/26.0");
        // build the request
        HttpEntity request = new HttpEntity(headers);

        // use `exchange` method for HTTP call
        ResponseEntity<IMBDResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, request, IMBDResponseDTO.class, 0);

        return response.getBody();
    }

}
