package com.microservice.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * IMDB API Company response Class for the Cinema APP
 *
 * @author bruno.martins.alexandre.1995@gmail.com
 * @version 1.0.0
 */
public class IMDBCompanyDTO implements Serializable {

    @JsonProperty("title")
    public String title;

    @JsonProperty("image")
    public String image;

    @JsonProperty("id")
    public String id;
}
