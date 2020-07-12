package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
@Data
@Entity(name = "ARTICLE")
@NoArgsConstructor
@AllArgsConstructor
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

    public ArticleDto dto() {
        return ArticleDto.builder()
                .titleShort(this.title.getTitleShort())
                .titleLong(this.title.getTitleLong())
                .content(this.content.getContent())
                .authorId(AuthorId.of(authorEntity.getAuthorId()))
                .build();
    }

}
