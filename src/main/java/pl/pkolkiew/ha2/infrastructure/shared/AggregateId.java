package pl.pkolkiew.ha2.infrastructure.shared;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created 9/12/2020
 */
@Embeddable
public class AggregateId implements Serializable {

    private Long aggregateId;

    public AggregateId(Long aggregateId) {
        Objects.requireNonNull(aggregateId);
        this.aggregateId = aggregateId;
    }

    protected AggregateId() {
    }

    public Long getId() {
        return aggregateId;
    }

    @Override
    public int hashCode() {
        return aggregateId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AggregateId other = (AggregateId) obj;
        if (aggregateId == null) {
            return other.aggregateId == null;
        } else return aggregateId.equals(other.aggregateId);
    }

    @Override
    public String toString() {
        return aggregateId.toString();
    }
}
