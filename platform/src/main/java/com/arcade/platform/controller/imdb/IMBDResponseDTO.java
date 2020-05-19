package com.arcade.platform.controller.imdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IMBDResponseDTO {

    @JsonProperty("titles")
    List<IMDBTitleDTO> titles;

    @JsonProperty("names")
    List<IMDBNameDTO> names;

    @JsonProperty("companies")
    List<IMDBCompanyDTO> companies;


}





