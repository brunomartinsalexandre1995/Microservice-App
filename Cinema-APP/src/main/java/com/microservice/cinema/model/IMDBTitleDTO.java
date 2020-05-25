package com.microservice.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMDBTitleDTO {

    @JsonProperty("title")
    public String title;

    @JsonProperty("image")
    public String image;

    @JsonProperty("id")
    public String id;

}