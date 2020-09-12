package pl.pkolkiew.ha2.article.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author pkolkiew
 * Created 8/22/2020
 */
@Getter
@Builder
@Entity(name = "ATTACHMENT")
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
class AttachmentEntity implements Serializable {
    @Id
    private Long attachmentId;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String attachment;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private ArticleEntity article;

}
