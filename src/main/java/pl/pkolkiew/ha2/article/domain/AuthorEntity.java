package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@Entity(name = "AUTHOR")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AuthorEntity {
    @Id
    @Column(name = "author_Id")
    private Long authorId;
    private String name;
    @Embedded
    private PublisherCompanyId publisherCompanyOwnerId;

}
