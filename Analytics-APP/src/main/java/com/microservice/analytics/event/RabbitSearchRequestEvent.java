package com.microservice.analytics.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RabbitSearchRequestEvent implements Serializable {

    @JsonProperty("eventId")
    private String eventId;

    @JsonProperty("searchContent")
    private String searchContent;

    @JsonProperty("microServiceName")
    private String microServiceName;


}
