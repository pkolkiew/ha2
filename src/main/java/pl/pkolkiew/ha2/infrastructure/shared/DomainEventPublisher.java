package pl.pkolkiew.ha2.infrastructure.shared;

import java.io.Serializable;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
public interface DomainEventPublisher {
    void publish(Serializable event);
}
