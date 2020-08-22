package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import pl.pkolkiew.ha2.article.domain.exceptions.ArticleNotFoundException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
interface ArticleRepository extends Repository<ArticleEntity, String> {
    ArticleEntity save(ArticleEntity entity);

    @Query("SELECT s FROM ARTICLE s WHERE s.title =:title")
    Optional<ArticleEntity> findOne(String title);

    @Query("DELETE FROM ARTICLE s WHERE s.title =:title")
    void delete(String title);

    Page<ArticleEntity> findAll(Pageable pageable);
}

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class InMemoryArticleRepository implements ArticleRepository {
    private final ConcurrentHashMap<Long, ArticleEntity> map = new ConcurrentHashMap<>();

    @Override
    public ArticleEntity save(ArticleEntity article) {
        requireNonNull(article);
        if (article.getId() == null)
            article.generateId();
        map.put(article.getId(), article);
        return article;
    }

    @Override
    public Optional<ArticleEntity> findOne(String title) {
        return map.values().stream().filter(x -> x.getTitle().getTitleLong().equalsIgnoreCase(title)).findFirst();
    }

    ArticleEntity findOneOrThrow(String title) {
        return findOne(title).stream().
                findFirst().
                orElseThrow(() -> new ArticleNotFoundException(title));
    }

    @Override
    public void delete(String title) {
        ArticleEntity article = findOne(title).stream()
                .findFirst()
                .orElseThrow(() -> new ArticleNotFoundException(title));
        map.remove(article.getId());
    }

    @Override
    public Page<ArticleEntity> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

}
