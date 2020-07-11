package pl.pkolkiew.ha2.article.domain;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class ArticlePublisher {
    private final ArticleRepository repository;

    public ArticlePublisher(ArticleRepository repository) {
        this.repository = repository;
    }
}
