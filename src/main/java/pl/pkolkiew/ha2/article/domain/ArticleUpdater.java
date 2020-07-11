package pl.pkolkiew.ha2.article.domain;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class ArticleUpdater {
    private final ArticleRepository repository;

    public ArticleUpdater(ArticleRepository repository) {
        this.repository = repository;
    }
}
