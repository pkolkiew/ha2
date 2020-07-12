package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;

import java.util.stream.Collectors;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class ArticleFactory {
    public Page<ArticleDto> dto(Page<ArticleEntity> all) {
        return new PageImpl<>(all.stream().map(x -> x.dto()).collect(Collectors.toList()));
    }

    public ArticleDto dto(ArticleEntity entity) {
        return ArticleDto.builder()
                .titleShort(entity.getTitle().getTitleShort())
                .titleLong(entity.getTitle().getTitleLong())
                .content(entity.getContent().getContent())
                .build();
    }

    public ArticleEntity entity(ArticleDto articleDto) {
        return ArticleEntity.of(articleDto);
    }
}
