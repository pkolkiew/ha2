package pl.pkolkiew.ha2.infrastructure.shared;

import org.springframework.context.annotation.Scope;

/**
 * @author pkolkiew
 * Created 9/12/2020
 */
@Scope("prototype")
public abstract class BaseAggregateRoot {
    public enum AggregateStatus {
        ACTIVE, ARCHIVE
    }


}
