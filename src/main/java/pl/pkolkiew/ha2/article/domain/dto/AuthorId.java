package pl.pkolkiew.ha2.article.domain.dto;

import lombok.Getter;
import lombok.Value;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@Getter
@Value(staticConstructor = "of")
public class AuthorId {
    private final Long authorId;
}
