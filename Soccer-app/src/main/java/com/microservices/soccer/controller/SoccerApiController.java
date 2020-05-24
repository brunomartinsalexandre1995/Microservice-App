package com.microservices.soccer.controller;

import com.microservices.soccer.service.WorldCupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/imdb")
public class SoccerApiController {

    WorldCupService worldCupService;

    @GetMapping("/soccer/world-cup/{year}")
    public ResponseEntity<WorldCupResponseDTO> worldCupInformationByYear(@PathVariable(value = "year") String year) {
        return ResponseEntity.status(HttpStatus.OK).body(worldCupService.searchRequest(year));
    }

    @Autowired
    public void setWorldCupService(WorldCupService worldCupService) {
        this.worldCupService = worldCupService;
    }


}
