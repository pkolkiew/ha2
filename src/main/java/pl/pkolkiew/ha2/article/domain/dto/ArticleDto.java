package pl.pkolkiew.ha2.article.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Getter
@Builder
@EqualsAndHashCode
public class ArticleDto {
    private final String titleShort;
    private final String titleLong;
    private final String content;
    private final AuthorId authorId;
}
