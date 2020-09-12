package pl.pkolkiew.ha2.bio.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pkolkiew.ha2.infrastructure.shared.AggregateId;
import pl.pkolkiew.ha2.infrastructure.shared.BaseAggregateRoot;

import javax.persistence.*;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Data
@NoArgsConstructor
@Entity(name = "bio")
class BioEntity extends BaseAggregateRoot {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "aggregateId", column = @Column(name = "bioId", nullable = false))})
    private AggregateId bioId;
    private String name;
    private String surname;

    public BioEntity(String name) {
        this.name = name;
    }
}
