package pl.pkolkiew.ha2.author.domain;

import pl.pkolkiew.ha2.article.domain.dto.AuthorDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import static java.util.Objects.requireNonNull;

public class AuthorFacade {

    private final AuthorFactory factory;
    private final AuthorService authorService;

    public AuthorFacade(AuthorRepository authorRepository) {
        this.factory = new AuthorFactory();
        this.authorService = new AuthorService(authorRepository);
    }

    public static AuthorFacade of() {
        return new AuthorConfiguration().authorFacade();
    }

    public void add(AuthorId authorId, AuthorDto authorDto) {
        requireNonNull(authorDto);
        AuthorEntity authorEntity = factory.from(authorId, null, authorDto);
        authorService.add(authorEntity);
    }
}
