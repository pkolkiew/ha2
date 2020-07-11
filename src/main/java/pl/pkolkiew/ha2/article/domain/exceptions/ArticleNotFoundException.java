package pl.pkolkiew.ha2.article.domain.exceptions;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String title) {
        super("Article with title: " + title + " not found", null, false, false);
    }
}
