package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class ArticleFactory {

    public Page<ArticleDto> dto(Page<ArticleEntity> all) {
        return new PageImpl<>(all.stream().map(x -> x.dto()).collect(Collectors.toList()));
    }

    public ArticleEntity from(ArticleDto articleDto) {
        requireNonNull(articleDto);
        return ArticleEntity.builder()
                .title(TitleEntity.builder()
                        .titleLong(articleDto.getTitleLong())
                        .titleShort(articleDto.getTitleShort())
                        .build())
                .content(ContentEntity.builder()
                        .content(articleDto.getContent())
                        .build())
                .authorId(articleDto.getAuthorId().getAuthorId())
                .build();
    }

}
