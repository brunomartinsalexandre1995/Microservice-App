package com.microservice.cinema.controller;

import com.microservice.cinema.model.IMBDResponseDTO;
import com.microservice.cinema.service.IMDBApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller used to search for cinema information
 *
 * @author bruno.martins.alexandre.1995@gmail.com
 * @version 1.0.0
 */
@RestController
public class CinemaController {

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
