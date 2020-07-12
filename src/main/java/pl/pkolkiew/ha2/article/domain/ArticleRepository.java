package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
interface ArticleRepository extends Repository<ArticleEntity, String> {
    ArticleEntity save(ArticleEntity entity);
    Optional<ArticleEntity> findOne(String title);
    void delete(String title);
    Page<ArticleEntity> findAll(Pageable pageable);
}
