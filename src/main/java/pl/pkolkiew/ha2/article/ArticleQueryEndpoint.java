package pl.pkolkiew.ha2.article;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.pkolkiew.ha2.article.domain.ArticleFacade;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@RestController
@AllArgsConstructor
class ArticleQueryEndpoint {
    private final ArticleFacade facade;

    @GetMapping("articles")
    Page<ArticleDto> findArticles(Pageable pageable) {
        return facade.findAll(pageable);
    }

    @GetMapping("article/{title}")
    ArticleDto findArticleByTitle(@PathVariable String title){
        return facade.show(title);
    }

}
