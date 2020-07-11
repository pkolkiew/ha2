package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;

import static java.util.Objects.nonNull;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
@Slf4j
@AllArgsConstructor
public class ArticleFacade {
    private final ArticleRepository repository;
    private final ArticleUpdater updater;
    private final ArticlePublisher publisher;
    private final ArticleFactory factory = new ArticleFactory();

    public Page<ArticleDto> findAll(Pageable pageable) {
        Page<ArticleEntity> all = repository.findAll(pageable);
        return factory.dto(all);
    }

    public ArticleDto show(String title) {
        ArticleEntity entity = repository.findOne(title);
        return factory.dto(entity);
    }

    public void add(ArticleDto articleDto) {
        nonNull(articleDto);
        ArticleEntity entity = factory.entity(articleDto);
        repository.save(entity);
    }
}
