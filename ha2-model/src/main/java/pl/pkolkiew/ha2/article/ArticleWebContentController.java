package pl.pkolkiew.ha2.article;

import pl.pkolkiew.ha2.article.domain.ArticleFacade;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
class ArticleWebContentController {
    private final ArticleFacade facade;

    ArticleWebContentController(ArticleFacade facade) {
        this.facade = facade;
    }
}
