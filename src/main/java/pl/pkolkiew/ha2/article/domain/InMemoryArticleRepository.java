package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.ha2.article.domain.exceptions.ArticleNotFoundException;
import pl.pkolkiew.ha2.article.domain.query.ArticleQueryDto;
import pl.pkolkiew.ha2.article.domain.query.ArticleQueryRepository;
import pl.pkolkiew.ha2.article.domain.query.ArticleSearchParams;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class InMemoryArticleRepository implements ArticleRepository, ArticleQueryRepository {
    private ConcurrentHashMap<Long, ArticleEntity> map = new ConcurrentHashMap<>();

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

    @Override
    public Page<ArticleQueryDto> findArticle(ArticleSearchParams articleSearchParams) {
        // W normalnym przypadku z articleSearchParams
        // 1. Tworzymy adapter do ktorego wstrzykujemy nasz interfejs extend'ujacy Crud/Jpa Repository
        // 2. Tworzymy Specification na podstawie ArticleSearchParams
        // 3. Piszemy JPQL zwracajacy DTO z tym co potrzebujemy w reponse
        return null;
    }


}
