package pl.pkolkiew.ha2.article.domain.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Getter
@Builder
public class ArticleDto {
    private final String articleTitle;
    private final String content;
}
