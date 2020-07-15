package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorDto;
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

    public ArticleEntity from(ArticleDto articleDto, AuthorEntity authorEntity) {
        requireNonNull(articleDto);
        return ArticleEntity.builder()
                .title(TitleEntity.builder()
                        .titleLong(articleDto.getTitleLong())
                        .titleShort(articleDto.getTitleShort())
                        .build())
                .content(ContentEntity.builder()
                        .content(articleDto.getContent())
                        .build())
                .authorEntity(authorEntity)
                .build();
    }

    public AuthorEntity from(AuthorId authorId, PublisherCompanyId publisherCompanyId, AuthorDto authorDto) {
        requireNonNull(authorDto);
        return AuthorEntity.builder()
                .authorId(authorId.getAuthorId())
                .name(authorDto.getName())
                .publisherCompanyOwnerId(publisherCompanyId)
                .build();
    }

}
