package com.arcade.platform.controller.imdb;

import com.arcade.platform.service.api.IMDBApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IMBDApiController {

    @Autowired
    IMDBApiService iMDBApiService;

    @GetMapping("/search")
    public ResponseEntity<IMBDResponseDTO> search() {
        return ResponseEntity.status(HttpStatus.OK).body(iMDBApiService.search());
    }

}
