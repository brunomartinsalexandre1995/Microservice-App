package com.microservice.platform.event;

import com.microservice.platform.persistence.PlatformSearchEvent;
import com.microservice.platform.persistence.PlatformSearchEventRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitEventHandler {

    private PlatformSearchEventRepository platformSearchEventRepository;

    @Autowired
    RabbitEventHandler(PlatformSearchEventRepository platformSearchEventRepository) {
        this.platformSearchEventRepository = platformSearchEventRepository;
    }

    @RabbitListener(queues = "${search.request.queue}")
    void handleSearchEventRequest(final RabbitSearchEvent event) {
        PlatformSearchEvent dbEvent = new PlatformSearchEvent();
        dbEvent.setEventId(event.getEventId());
        dbEvent.setMicroServiceName(event.getMicroServiceName());
        dbEvent.setSearchContent(event.getSearchContent());
        platformSearchEventRepository.save(dbEvent);
    }

}
