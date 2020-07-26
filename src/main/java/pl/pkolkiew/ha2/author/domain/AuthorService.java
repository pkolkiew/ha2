package pl.pkolkiew.ha2.author.domain;

import lombok.AllArgsConstructor;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;
import pl.pkolkiew.ha2.article.domain.exceptions.AuthorNotFoundException;

import java.util.Optional;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@AllArgsConstructor
class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorEntity findOneById(AuthorId authorId) {
        Optional<AuthorEntity> authorEntity = authorRepository.findOneById(authorId);
        if (!authorEntity.isPresent())
            throw new AuthorNotFoundException(authorId.getAuthorId());
        return authorEntity.get();
    }

    public void add(AuthorEntity authorEntity) {
        authorRepository.add(authorEntity);
    }
}
