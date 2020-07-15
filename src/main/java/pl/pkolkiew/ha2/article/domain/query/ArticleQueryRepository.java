package pl.pkolkiew.ha2.article.domain.query;

import org.springframework.data.domain.Page;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
public interface ArticleQueryRepository {

    Page<ArticleQueryDto> findArticle(ArticleSearchParams articleSearchParams);

}
