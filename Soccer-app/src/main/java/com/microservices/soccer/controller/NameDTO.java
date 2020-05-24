package com.microservices.soccer.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NameDTO {

    @JsonProperty("tri")
    String tri;

    @JsonProperty("flag")
    String flag;

    @JsonProperty("full")
    String full;


}