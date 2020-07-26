package pl.pkolkiew.ha2.article.domain.exceptions;

public class ArticleAlreadyExistException extends RuntimeException {
    public ArticleAlreadyExistException(String titleLong) {
        super("Article with long title: " + titleLong + " already exist in DB", null, false, false);
    }
}
