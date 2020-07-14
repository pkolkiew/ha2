package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@AllArgsConstructor
class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleEntity findOne(String title) {
        return articleRepository.findOne(title).get();
    }

    public Page<ArticleEntity> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    public void save(ArticleEntity entity) {

        articleRepository.save(entity);
    }
}
