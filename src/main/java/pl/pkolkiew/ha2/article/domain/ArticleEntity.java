package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Random;
import java.util.Set;

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

    private Long authorId;

    @OneToMany(mappedBy = "article")
    private Set<AttachmentEntity> attachments;

    ArticleDto dto() {
        return ArticleDto.builder()
                .titleShort(this.title.getTitleShort())
                .titleLong(this.title.getTitleLong())
                .content(this.content.getContent())
                .authorId(AuthorId.of(this.authorId))
                .build();
    }

    Long generateId() {
        this.id = new Random().nextLong();
        return this.id;
    }

}
