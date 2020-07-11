package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.ha2.article.domain.exceptions.ArticleNotFoundException;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class InMemoryArticleRepository implements ArticleRepository {
    private ConcurrentHashMap<String, ArticleEntity> map = new ConcurrentHashMap<>();

    @Override
    public ArticleEntity save(ArticleEntity article) {
        requireNonNull(article);
        map.put(article.getTitle(), article);
        return article;
    }

    @Override
    public ArticleEntity findOne(String title) {
        return map.get(title);
    }

    ArticleEntity findOneOrThrow(String title) {
        ArticleEntity article = map.get(title);
        if (article == null)
            throw new ArticleNotFoundException(title);
        return article;
    }

    @Override
    public void delete(String title) {
        map.remove(title);
    }

    @Override
    public Page<ArticleEntity> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

}
