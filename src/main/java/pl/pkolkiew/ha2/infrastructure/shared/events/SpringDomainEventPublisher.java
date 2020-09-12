package pl.pkolkiew.ha2.infrastructure.shared.events;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
@AllArgsConstructor
class SpringDomainEventPublisher implements DomainEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(DomainEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
