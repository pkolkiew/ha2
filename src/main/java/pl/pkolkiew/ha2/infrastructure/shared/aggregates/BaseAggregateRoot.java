package pl.pkolkiew.ha2.infrastructure.shared.aggregates;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import pl.pkolkiew.ha2.infrastructure.shared.events.DomainEventPublisher;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author pkolkiew
 * Created 9/12/2020
 * based on: <u>https://github.com/BottegaIT/ddd-leaven-v2</u>
 */
@Getter(AccessLevel.PROTECTED)
@Scope("prototype")
@MappedSuperclass
@EqualsAndHashCode
public abstract class BaseAggregateRoot {
    public enum AggregateStatus {
        ACTIVE, ARCHIVE
    }

    protected boolean isActive;
    protected LocalDateTime insertDate;
    protected LocalDateTime modifyDate;
    @Version
    protected Timestamp version;

    @Enumerated(EnumType.ORDINAL)
    private AggregateStatus aggregateStatus = AggregateStatus.ACTIVE;

    @Transient
    protected DomainEventPublisher eventPublisher;

    public void markAsRemoved() {
        aggregateStatus = AggregateStatus.ARCHIVE;
    }

}
