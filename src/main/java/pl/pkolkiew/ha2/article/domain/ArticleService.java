package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;
import pl.pkolkiew.ha2.article.domain.exceptions.ArticleAlreadyExistException;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
class ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticlePolicy articlePolicy;
    private final ArticleFactory factory;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.articlePolicy = new ArticleAddNewPolicy();
        this.factory = new ArticleFactory();
    }

    public ArticleEntity findOne(String title) {
        return articleRepository.findOne(title).get();
    }

    public Page<ArticleEntity> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    public void save(ArticleDto dto) {
        articleRepository.findOne(dto.getTitleLong()).stream()
                .findAny()
                .ifPresent(entity -> {
                    throw new ArticleAlreadyExistException(dto.getTitleLong());
                });
        ArticleEntity articleEntity = factory.from(dto);
        articleRepository.save(articleEntity);
    }
}
