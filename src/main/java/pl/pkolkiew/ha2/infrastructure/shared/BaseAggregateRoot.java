package pl.pkolkiew.ha2.infrastructure.shared;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.context.annotation.Scope;

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
public abstract class BaseAggregateRoot {
    public enum AggregateStatus {
        ACTIVE, ARCHIVE
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idValue", column = @Column(name = "aggregateId", nullable = false))})
    protected AggregateId aggregateId;

    protected boolean isActive;
    protected LocalDateTime insertDate;
    protected LocalDateTime modifyDate;
    @Version
    protected Timestamp version;

    @Enumerated(EnumType.ORDINAL)
    private AggregateStatus aggregateStatus = AggregateStatus.ACTIVE;

    @Transient
    protected DomainEventPublisher eventPublisher;

    public AggregateId getAggregateId() {
        return aggregateId;
    }

    public void markAsRemoved() {
        aggregateStatus = AggregateStatus.ARCHIVE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj instanceof BaseAggregateRoot) {
            BaseAggregateRoot other = (BaseAggregateRoot) obj;
            if (other.aggregateId == null)
                return false;
            return other.aggregateId.equals(aggregateId);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return aggregateId.hashCode();
    }
}
