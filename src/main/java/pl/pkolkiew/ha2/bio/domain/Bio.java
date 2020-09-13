package pl.pkolkiew.ha2.bio.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * @author pkolkiew
 * Created 9/13/2020
 */
@Builder
@Getter
class Bio {
    private final Long bioId;
    private final String name;
    private final String surname;
}
