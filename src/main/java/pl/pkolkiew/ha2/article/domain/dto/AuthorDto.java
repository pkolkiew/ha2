package pl.pkolkiew.ha2.article.domain.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * @author pkolkiew
 * Created 7/14/2020
 */
@Getter
@Builder
public class AuthorDto {
    private final String name;
}
