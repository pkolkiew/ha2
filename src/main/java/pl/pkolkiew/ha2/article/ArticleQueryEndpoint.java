package pl.pkolkiew.ha2.article;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.pkolkiew.ha2.article.domain.ArticleFacade;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;
import pl.pkolkiew.ha2.article.domain.query.ArticleQueryDto;
import pl.pkolkiew.ha2.article.domain.query.ArticleQueryRepository;
import pl.pkolkiew.ha2.article.domain.query.ArticleSearchParams;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@RestController
@AllArgsConstructor
class ArticleQueryEndpoint {
    private final ArticleFacade facade;
    private final ArticleQueryRepository articleQueryRepository;

    @GetMapping("articles")
    Page<ArticleDto> findArticles(Pageable pageable) {
        return facade.findAll(pageable);
    }

    @GetMapping("article/{title}")
    ArticleDto findArticleByTitle(@PathVariable String title) {
        return facade.show(title);
    }

    @PutMapping("article")
    Page<ArticleQueryDto> findArticlesByAuthor(@RequestBody ArticleSearchParams searchParams) {
        return articleQueryRepository.findArticle(searchParams);
    }

}
