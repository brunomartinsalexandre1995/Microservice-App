package com.movieApp.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RabbitSearchEvent implements Serializable {

    @JsonProperty("eventId")
    private final String eventId;

    @JsonProperty("searchContent")
    private final String searchContent;

    @JsonProperty("microServiceName")
    private final String microServiceName;


}
