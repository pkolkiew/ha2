package pl.pkolkiew.ha2.author.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
interface AuthorRepository extends Repository<AuthorEntity, Long> {

    @Query("SELECT s FROM AUTHOR s WHERE s.authorId =:authorId")
    Optional<AuthorEntity> findOneById(AuthorId authorId);

    void save(AuthorEntity authorEntity);
}

class InMemoryAuthorRepository implements AuthorRepository {
    private final ConcurrentHashMap<Long, AuthorEntity> map = new ConcurrentHashMap<>();

    @Override
    public Optional<AuthorEntity> findOneById(AuthorId authorId) {
        return Optional.of(map.get(authorId.getAuthorId()));
    }

    @Override
    public void save(AuthorEntity authorEntity) {
        map.put(authorEntity.getAuthorId(), authorEntity);
    }

}