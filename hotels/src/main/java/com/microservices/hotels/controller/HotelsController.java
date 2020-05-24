package com.microservices.hotels.controller;

import com.microservices.hotels.dto.HotelSearchDTO;
import com.microservices.hotels.service.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class HotelsController {

    private HotelsService hotelsService;

    @GetMapping("hotel/search")
    public ResponseEntity<HotelSearchDTO> search(@PathParam(value = "location") String query) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelsService.searchRequest(query));
    }

    @Autowired
    public void setHotelsService(HotelsService hotelsService) {
        this.hotelsService = hotelsService;
    }


}
