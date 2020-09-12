package pl.pkolkiew.ha2.infrastructure.shared.events;

import java.util.List;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
public interface DomainEventPublisher {
    void publish(DomainEvent event);

    default void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }
}