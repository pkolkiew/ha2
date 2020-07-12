package pl.pkolkiew.ha2.article.domain.exceptions;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long authorId) {
        super("Author with id: " + authorId + " not found", null, false, false);
    }
}
