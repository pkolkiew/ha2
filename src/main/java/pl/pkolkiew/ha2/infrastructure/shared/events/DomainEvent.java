package pl.pkolkiew.ha2.infrastructure.shared.events;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
public interface DomainEvent extends Serializable {

    UUID getEventId();

    Long getAggregateId();

    Instant getWhen();
}
