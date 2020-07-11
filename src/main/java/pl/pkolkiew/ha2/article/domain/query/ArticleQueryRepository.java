package pl.pkolkiew.ha2.article.domain.query;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
public interface ArticleQueryRepository {

    ArticleQueryDto findArticle(ArticleSearchParams articleSearchParams);


}
