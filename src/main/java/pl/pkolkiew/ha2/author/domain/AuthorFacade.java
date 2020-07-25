package pl.pkolkiew.ha2.author.domain;

import lombok.AllArgsConstructor;
import pl.pkolkiew.ha2.article.domain.dto.AuthorDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
public class AuthorFacade {

    private final AuthorFactory factory;
    private final AuthorService authorService;
    /**
     * To jest do wywalenia do własnej domeny, na potrzeby przykładu zostało zaimplementowane tutaj
     *
     * @param authorId
     * @param authorDto
     */
    public void add(AuthorId authorId, AuthorDto authorDto) {
        requireNonNull(authorDto);
        AuthorEntity authorEntity = factory.from(authorId, null, authorDto);
        authorService.add(authorEntity);
    }
}
