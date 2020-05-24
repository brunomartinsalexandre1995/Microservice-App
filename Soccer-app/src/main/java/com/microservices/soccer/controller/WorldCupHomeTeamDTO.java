package com.microservices.soccer.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorldCupHomeTeamDTO {

    @JsonProperty("Stats")
    StatsDTO stats;

    @JsonProperty("name")
    NameDTO nameDTO;

}



