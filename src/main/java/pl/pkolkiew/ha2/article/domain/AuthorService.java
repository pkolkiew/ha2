package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import java.util.Optional;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@AllArgsConstructor
class AuthorService {
    private final AuthorRepository authorRepository;

    public Optional<AuthorEntity> findOneById(AuthorId authorId) {
        return authorRepository.findOneById(authorId);
    }

    public void add(AuthorEntity authorEntity) {
        authorRepository.add(authorEntity);
    }
}
