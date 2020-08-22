package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author pkolkiew
 * Created 8/22/2020
 */
@Getter
@Builder
@Entity(name = "ATTACHMENT")
@NoArgsConstructor
@AllArgsConstructor
class AttachmentEntity {
    @Id
    private Long attachmentId;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleEntity article;

}
