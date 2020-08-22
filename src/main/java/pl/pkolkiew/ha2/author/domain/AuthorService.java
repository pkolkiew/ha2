package pl.pkolkiew.ha2.author.domain;

import lombok.AllArgsConstructor;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;
import pl.pkolkiew.ha2.article.domain.exceptions.AuthorNotFoundException;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@AllArgsConstructor
class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorEntity findOneById(AuthorId authorId) {
        return authorRepository.findOneById(authorId)
                .stream().findFirst()
                .orElseThrow(() -> new AuthorNotFoundException(authorId.getAuthorId()));

    }

    public void add(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }
}
