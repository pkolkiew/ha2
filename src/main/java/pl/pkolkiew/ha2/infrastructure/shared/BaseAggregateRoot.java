package pl.pkolkiew.ha2.infrastructure.shared;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
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
@MappedSuperclass
@EqualsAndHashCode
public abstract class BaseAggregateRoot {
    public enum AggregateStatus {
        ACTIVE, ARCHIVE
    }
//
//    @EmbeddedId
//    @AttributeOverrides({
//            @AttributeOverride(name = "idValue", column = @Column(name = "aggregateId", nullable = false))})
//    protected AggregateId aggregateId;

    protected boolean isActive;
    protected LocalDateTime insertDate;
    protected LocalDateTime modifyDate;
    @Version
    protected Timestamp version;

    @Enumerated(EnumType.ORDINAL)
    private AggregateStatus aggregateStatus = AggregateStatus.ACTIVE;

    @Transient
    protected DomainEventPublisher eventPublisher;

//    public AggregateId getAggregateId() {
//        return aggregateId;
//    }

    public void markAsRemoved() {
        aggregateStatus = AggregateStatus.ARCHIVE;
    }

}
