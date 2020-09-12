package pl.pkolkiew.ha2.infrastructure.shared.events;

import java.util.List;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
public interface EventsStorage {

    void save(DomainEvent event);

    List<DomainEvent> toPublish();

    void published(List<DomainEvent> events);

}
