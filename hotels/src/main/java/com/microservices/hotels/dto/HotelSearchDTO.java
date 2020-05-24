package com.microservices.hotels.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelSearchDTO {

    @JsonProperty("moresuggestions")
    String moresuggestions;

    @JsonProperty("autoSuggestInstance")
    String autoSuggestInstance;

    @JsonProperty("trackingID")
    String trackingID;

    @JsonProperty("misspellingfallback")
    Boolean misspellingfallback;

    @JsonProperty("suggestions")
    List<HotelSearchSuggestionDTO> suggestions;
}
