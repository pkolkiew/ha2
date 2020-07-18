package pl.pkolkiew.ha2.article.domain.query;

import lombok.Getter;
import lombok.Value;
import pl.pkolkiew.ha2.article.domain.dto.ArticleId;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Getter
@Value(staticConstructor = "of")
public class ArticleSearchParams {
    private final String title;
    private final ArticleId articleId;
    private final AuthorId authorId;

}
