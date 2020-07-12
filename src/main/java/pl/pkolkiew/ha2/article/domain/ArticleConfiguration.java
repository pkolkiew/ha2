package pl.pkolkiew.ha2.article.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Configuration
class ArticleConfiguration {

    /*
        It's called 'JavaConfig'.
        We need to get I/O in input parameters.
     */
    @Bean
    ArticleFacade articleFacade(ArticleRepository articleRepository, AuthorRepository authorRepository) {
        ArticleUpdater updater = new ArticleUpdater(articleRepository);
        ArticlePublisher publisher = new ArticlePublisher(articleRepository);
        ArticleService articleService = new ArticleService(articleRepository, authorRepository);
        AuthorService authorService = new AuthorService(authorRepository);
        return new ArticleFacade(updater, publisher, articleService, authorService);
    }
}