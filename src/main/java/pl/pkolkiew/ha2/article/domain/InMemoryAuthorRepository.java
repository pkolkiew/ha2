package pl.pkolkiew.ha2.article.domain;

import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class InMemoryAuthorRepository implements AuthorRepository {
    private ConcurrentHashMap<Long, AuthorEntity> map = new ConcurrentHashMap<>();

    @Override
    public Optional<AuthorEntity> findOneById(AuthorId authorId) {
        return Optional.of(map.get(authorId.getAuthorId()));
    }

    @Override
    public void add(AuthorEntity authorEntity) {
        map.put(authorEntity.getAuthorId(), authorEntity);
    }

}
