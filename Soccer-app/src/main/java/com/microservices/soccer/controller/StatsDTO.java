package com.microservices.soccer.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsDTO{

    @JsonProperty("outcome")
    String outcome;

    @JsonProperty("score_opposing")
    String scoreOpposing;

    @JsonProperty("score")
    String score;



}