package pl.pkolkiew.ha2.infrastructure.shared.events;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
public class InMemoryEventsStorage implements EventsStorage {

    private final java.util.List<DomainEvent> eventList = Collections.synchronizedList(new ArrayList<>());

    @Override
    synchronized public void save(DomainEvent event) {
        eventList.add(event);
    }

    @Override
    synchronized public List<DomainEvent> toPublish() {
        return eventList.stream().collect(Collectors.toList());
    }

    @Override
    synchronized public void published(List<DomainEvent> events) {
        eventList.removeAll(events);
    }
}
