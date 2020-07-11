package pl.pkolkiew.ha2.article;

import pl.pkolkiew.ha2.article.domain.ArticleFacade;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
class ArticleContentValidatorController {
    private final ArticleFacade facade;

    ArticleContentValidatorController(ArticleFacade facade) {
        this.facade = facade;
    }
}
