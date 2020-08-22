package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;
import pl.pkolkiew.ha2.article.domain.query.ArticleQueryDto;
import pl.pkolkiew.ha2.article.domain.query.ArticleQueryRepository;
import pl.pkolkiew.ha2.article.domain.query.ArticleSearchParams;

/**
 * @author pkolkiew
 * Created 8/22/2020
 */
@AllArgsConstructor
class ArticleQuerySpringRepository implements ArticleQueryRepository {

    private final ArticleQueryCrudRepository articleQueryCrudRepository;

    @Override
    public Page<ArticleQueryDto> findArticle(ArticleSearchParams articleSearchParams) {
        return null;
    }
}

interface ArticleQueryCrudRepository extends Repository<ArticleEntity, Long> {
}
