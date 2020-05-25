package com.microservices.travel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelSearchSuggestionDTO {

    @JsonProperty("group")
    String group;

    @JsonProperty("entities")
    List<HotelSearchSuggestionEntityDTO> entities;

}
