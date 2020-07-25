package pl.pkolkiew.ha2.author.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class PublisherCompanyId {
    private Long publisherCompanyId;

}
