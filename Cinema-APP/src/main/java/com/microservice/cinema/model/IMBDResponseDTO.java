package com.microservice.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * IMDB API response Class for the Cinema APP
 *
 * @author bruno.martins.alexandre.1995@gmail.com
 * @version 1.0.0
 */
public class IMBDResponseDTO implements Serializable {

    @JsonProperty("titles")
    public List<IMDBTitleDTO> titles;

    @JsonProperty("names")
    public List<IMDBNameDTO> names;

    @JsonProperty("companies")
    public List<IMDBCompanyDTO> companies;


}





