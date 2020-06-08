package com.microservice.cinema.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Search Event class for the Cinema APP
 *
 * @author bruno.martins.alexandre.1995@gmail.com
 * @version 1.0.0
 */
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class SearchRequestEvent implements Serializable {

    @JsonProperty("eventId")
    private final String eventId;

    @JsonProperty("searchContent")
    private final String searchContent;

    @JsonProperty("microServiceName")
    private final String microServiceName;


}
