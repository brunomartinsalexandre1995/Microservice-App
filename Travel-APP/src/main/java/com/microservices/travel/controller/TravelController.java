package com.microservices.travel.controller;

import com.microservices.travel.dto.HotelSearchDTO;
import com.microservices.travel.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class TravelController {

    private TravelService hotelsService;

    @GetMapping("hotel/search")
    public ResponseEntity<HotelSearchDTO> search(@PathParam(value = "location") String query) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(hotelsService.searchRequest(query));
    }

    @Autowired
    public void setHotelsService(TravelService hotelsService) {
        this.hotelsService = hotelsService;
    }


}
