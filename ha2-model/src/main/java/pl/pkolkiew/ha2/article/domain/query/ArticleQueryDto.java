package pl.pkolkiew.ha2.article.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.pkolkiew.ha2.article.domain.dto.ArticleId;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Getter
@Builder
@ToString(exclude = "content")
@AllArgsConstructor
public class ArticleQueryDto {
    private final ArticleId articleId;
    private final String articleName;
    //TODO: to impl
    private final String author;
    private final String content;
}
