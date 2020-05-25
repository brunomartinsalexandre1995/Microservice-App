package com.microservice.cinema.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitSearchRequestEventDispatcher {

    private RabbitTemplate rabbitTemplate;
    private String searchExchange;
    private String searchRoutingKey;

    @Autowired
    RabbitSearchRequestEventDispatcher(final RabbitTemplate rabbitTemplate,
                                       @Value("${search.request.exchange}") final String searchExchange,
                                       @Value("${search.request.key}") final String searchRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.searchExchange = searchExchange;
        this.searchRoutingKey = searchRoutingKey;
    }

    public void send(final SearchRequestEvent searchRequestEvent) {
        rabbitTemplate.convertAndSend(searchExchange, searchRoutingKey, searchRequestEvent);
    }

}
