package com.microservices.soccer.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorldCuplocationDTO {

    @JsonProperty("country")
    String country;

    @JsonProperty("city")
    String city;
}
