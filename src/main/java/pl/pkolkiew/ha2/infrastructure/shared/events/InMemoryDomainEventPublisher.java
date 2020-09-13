package pl.pkolkiew.ha2.infrastructure.shared.events;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
@Slf4j
@AllArgsConstructor
public class InMemoryDomainEventPublisher implements DomainEventPublisher {

    private final DomainEventPublisher domainEventPublisher;
    private final EventsStorage eventsStorage;

    @Override
    public void publish(DomainEvent event) {
        eventsStorage.save(event);
    }

    @Scheduled(fixedRate = 3000L)
    @Transactional
    public void publishAllPeriodically() {
        log.info("InMemEventPublisher.publishAllPeriodically()");
        List<DomainEvent> domainEvents = eventsStorage.toPublish();
        domainEvents.forEach(event -> {
            domainEventPublisher.publish(event);
            log.info("Published event with id: " + event.getEventId() + ", aggregateId:" + event.getAggregateId());
        });
        eventsStorage.published(domainEvents);
    }
}