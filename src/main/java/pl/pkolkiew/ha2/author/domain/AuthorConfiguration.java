package pl.pkolkiew.ha2.author.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorConfiguration {

    AuthorFacade authorFacade() {
        return new AuthorFacade(new InMemoryAuthorRepository());
    }

    @Bean
    AuthorFacade authorFacade(AuthorRepository authorRepository) {
        return new AuthorFacade(authorRepository);
    }
}
