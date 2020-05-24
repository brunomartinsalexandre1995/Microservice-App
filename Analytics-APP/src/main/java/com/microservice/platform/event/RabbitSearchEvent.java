package com.microservice.platform.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RabbitSearchEvent implements Serializable {

    @JsonProperty("eventId")
    private String eventId;

    @JsonProperty("searchContent")
    private String searchContent;

    @JsonProperty("microServiceName")
    private String microServiceName;


}
