package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
class ArticleEntity {
    @Id
    private String title;
    private String content;

    public ArticleDto dto() {
        return ArticleDto.builder()
                .articleTitle(this.title)
                .content(this.content)
                .build();
    }

    public static ArticleEntity of(ArticleDto dto) {
        return new ArticleEntity(dto.getArticleTitle(), dto.getContent());
    }

}
