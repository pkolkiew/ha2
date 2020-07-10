package pl.pkolkiew.ha2.article.domain.exceptions;

import pl.pkolkiew.ha2.article.domain.dto.ArticleId;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(ArticleId articleId) {
        super("Article with id: " + articleId.getId() + " not found");
    }
}
