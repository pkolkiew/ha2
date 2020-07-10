package pl.pkolkiew.ha2.article.domain.dto;

import lombok.Getter;
import lombok.Value;

import java.util.UUID;

/**
 * @author pkolkiew
 * Created 7/10/2020
 */
@Value
@Getter
public class ArticleId {
    private final UUID id;
}
