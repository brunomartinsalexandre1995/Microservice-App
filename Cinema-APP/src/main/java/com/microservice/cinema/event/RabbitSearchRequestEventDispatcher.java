package com.microservice.cinema.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ Search Event Dispatcher Class for the Cinema APP
 *
 * @author bruno.martins.alexandre.1995@gmail.com
 * @version 1.0.0
 */
@Component
public class RabbitSearchRequestEventDispatcher {

    private RabbitTemplate rabbitTemplate;
    private String searchExchange;
    private String searchRoutingKey;

    @Autowired
    RabbitSearchRequestEventDispatcher(final RabbitTemplate rabbitTemplate,
                                       @Value("${rabbit.search.exchange}") final String searchExchange,
                                       @Value("${rabbit.search.key}") final String searchRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.searchExchange = searchExchange;
        this.searchRoutingKey = searchRoutingKey;
    }

    public void send(final SearchRequestEvent searchRequestEvent) {
        try {
            rabbitTemplate.convertAndSend(searchExchange, searchRoutingKey, searchRequestEvent);
        }catch(Exception ex){
            //TODO Do nothing for now
        }
    }

}
