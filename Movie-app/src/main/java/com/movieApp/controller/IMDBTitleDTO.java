package com.arcade.platform.controller.imdb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMDBTitleDTO {

    @JsonProperty("title")
    String title;

    @JsonProperty("image")
    String image;

    @JsonProperty("id")
    String id;

}