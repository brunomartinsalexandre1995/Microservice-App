package com.movieApp.controller;

import com.movieApp.service.IMDBApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/imdb")
public class IMBDApiController {

    IMDBApiService imdbApiService;

    @GetMapping("/search/{content}")
    public ResponseEntity<IMBDResponseDTO> search(@PathVariable(value = "content") String content) {
        return ResponseEntity.status(HttpStatus.OK).body(imdbApiService.searchRequest(content));
    }

    @Autowired
    public void setImdbApiService(IMDBApiService imdbApiService) {
        this.imdbApiService = imdbApiService;
    }


}
