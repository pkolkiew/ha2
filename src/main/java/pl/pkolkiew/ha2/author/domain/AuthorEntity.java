package pl.pkolkiew.ha2.author.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@Getter
@Builder
@Entity(name = "AUTHOR")
@NoArgsConstructor
@AllArgsConstructor
class AuthorEntity implements Serializable {
    @Id
    @Column(name = "author_Id")
    private Long authorId;
    private String name;
    @Embedded
    private PublisherCompanyId publisherCompanyOwnerId;

}
