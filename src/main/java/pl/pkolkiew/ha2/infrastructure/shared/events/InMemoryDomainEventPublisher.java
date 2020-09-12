package pl.pkolkiew.ha2.infrastructure.shared.events;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
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
        List<DomainEvent> domainEvents = eventsStorage.toPublish();
        domainEvents.forEach(domainEventPublisher::publish);
        eventsStorage.published(domainEvents);
    }
}