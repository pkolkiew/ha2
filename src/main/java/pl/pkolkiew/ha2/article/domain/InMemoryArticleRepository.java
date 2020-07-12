package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.ha2.article.domain.exceptions.ArticleNotFoundException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class InMemoryArticleRepository implements ArticleRepository {
    private ConcurrentHashMap<Long, ArticleEntity> map = new ConcurrentHashMap<>();

    @Override
    public ArticleEntity save(ArticleEntity article) {
        requireNonNull(article);
        map.put(article.getId(), article);
        return article;
    }

    @Override
    public Optional<ArticleEntity> findOne(String title) {
        return map.values().stream().filter(x -> x.getTitle().getTitleLong().equalsIgnoreCase(title)).findFirst();
    }

    ArticleEntity findOneOrThrow(String title) {
        Optional<ArticleEntity> article = findOne(title);
        if (!article.isPresent())
            throw new ArticleNotFoundException(title);
        return article.get();
    }

    @Override
    public void delete(String title) {
        Optional<ArticleEntity> article = findOne(title);
        if (!article.isPresent())
            throw new ArticleNotFoundException(title);
        map.remove(article.get().getId());
    }

    @Override
    public Page<ArticleEntity> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

}
