package pl.pkolkiew.ha2.article.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pkolkiew.ha2.author.domain.AuthorFacade;


/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Configuration
class ArticleConfiguration {

    ArticleFacade articleFacade() {
        AuthorFacade authorFacade = AuthorFacade.of();
        return articleFacade(new InMemoryArticleRepository(), authorFacade);
    }

    /*
        It's called 'JavaConfig'.
        We need to get I/O in input parameters.
     */
    @Bean
    ArticleFacade articleFacade(ArticleRepository articleRepository, AuthorFacade authorFacade) {
        ArticleUpdater updater = new ArticleUpdater(articleRepository);
        ArticlePublisher publisher = new ArticlePublisher(articleRepository);
        ArticleService articleService = new ArticleService(articleRepository);
        return new ArticleFacade(updater, publisher, articleService, authorFacade);
    }
}