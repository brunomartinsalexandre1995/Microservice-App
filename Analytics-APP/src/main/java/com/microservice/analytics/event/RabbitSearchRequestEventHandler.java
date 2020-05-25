package com.microservice.analytics.event;

import com.microservice.analytics.persistence.DBSearchRequestEntry;
import com.microservice.analytics.persistence.DBSearchRequestEntryRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSearchRequestEventHandler {

    private DBSearchRequestEntryRepository DBSearchRequestEntryRepository;

    @Autowired
    RabbitSearchRequestEventHandler(DBSearchRequestEntryRepository DBSearchRequestEntryRepository) {
        this.DBSearchRequestEntryRepository = DBSearchRequestEntryRepository;
    }

    @RabbitListener(queues = "${search.request.queue}")
    DBSearchRequestEntry handleSearchEventRequest(final RabbitSearchRequestEvent event) {
        DBSearchRequestEntry dbEvent = new DBSearchRequestEntry();
        dbEvent.setEventId(event.getEventId());
        dbEvent.setMicroServiceName(event.getMicroServiceName());
        dbEvent.setSearchContent(event.getSearchContent());
        return DBSearchRequestEntryRepository.save(dbEvent);
    }

}
