package com.microservices.hotels.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelSearchSuggestionEntityDTO {

    @JsonProperty("geoId")
    String geoId;

    @JsonProperty("destinationId")
    String destinationId;

    @JsonProperty("landmarkCityDestinationId")
    String landmarkCityDestinationId;

    @JsonProperty("type")
    String type;

    @JsonProperty("caption")
    String caption;

    @JsonProperty("redirectPage")
    String redirectPage;

    @JsonProperty("latitude")
    String latitude;

    @JsonProperty("longitude")
    String longitude;

    @JsonProperty("name")
    String name;


}
