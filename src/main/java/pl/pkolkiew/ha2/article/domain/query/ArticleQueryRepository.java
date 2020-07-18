package pl.pkolkiew.ha2.article.domain.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
public interface ArticleQueryRepository {

    Page<ArticleQueryDto> findArticle(ArticleSearchParams articleSearchParams);

}

class InMemoryArticleQueryRepository implements ArticleQueryRepository {

    private ConcurrentHashMap<UUID, ArticleQueryDto> map = new ConcurrentHashMap<>();

    @Override
    public Page<ArticleQueryDto> findArticle(ArticleSearchParams articleSearchParams) {
        // dummy impl
        ArticleQueryDto articleQueryDto = map.get(articleSearchParams.getAuthorId());
        List result = new ArrayList<>();
        result.add(articleQueryDto);
        return new PageImpl<>(result);
    }

}