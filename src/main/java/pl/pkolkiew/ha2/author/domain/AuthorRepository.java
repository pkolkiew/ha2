package pl.pkolkiew.ha2.author.domain;

import org.springframework.data.repository.Repository;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
public interface AuthorRepository extends Repository<AuthorEntity, Long> {

    Optional<AuthorEntity> findOneById(AuthorId authorId);

    void add(AuthorEntity authorEntity);
}

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