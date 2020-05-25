package com.microservice.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IMBDResponseDTO {

    @JsonProperty("titles")
    public List<IMDBTitleDTO> titles;

    @JsonProperty("names")
    public List<IMDBNameDTO> names;

    @JsonProperty("companies")
    public List<IMDBCompanyDTO> companies;


}





