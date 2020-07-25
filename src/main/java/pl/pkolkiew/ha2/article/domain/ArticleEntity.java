package pl.pkolkiew.ha2.article.domain;

import lombok.*;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;
import pl.pkolkiew.ha2.author.domain.AuthorEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
@Getter
@Builder
@Entity(name = "ARTICLE")
@AllArgsConstructor
@NoArgsConstructor
class ArticleEntity implements Serializable {
    @Id
    private Long id;
    @Embedded
    private TitleEntity title;
    @Embedded
    private ContentEntity content;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_Id", nullable = false)
    private AuthorEntity authorEntity;

    ArticleDto dto() {
        return ArticleDto.builder()
                .titleShort(this.title.getTitleShort())
                .titleLong(this.title.getTitleLong())
                .content(this.content.getContent())
                .authorId(AuthorId.of(authorEntity.getAuthorId()))
                .build();
    }

    Long generateId() {
        this.id = new Random().nextLong();
        return this.id;
    }

}
