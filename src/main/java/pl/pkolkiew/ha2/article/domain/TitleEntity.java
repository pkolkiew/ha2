package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author pkolkiew
 * Created 7/12/2020
 */
@Embeddable
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
class TitleEntity {
    private String titleShort;
    private String titleLong;

//    public static TitleEntity of(Title title) {
//        return TitleEntity.builder()
//                .titleShort(title.getTitleShort())
//                .titleLong(title.getTitleLong())
//                .build();
//    }
}
