package pl.pkolkiew.ha2.bio.domain;

import javax.persistence.Transient;

/**
 * @author pkolkiew
 * Created 9/6/2020
 */
abstract class BioAbstract {

    private Long id;
    @Transient
    private final BioPolicy bioPolicy;

    protected BioAbstract(BioPolicy bioPolicy) {
        this.bioPolicy = bioPolicy;
    }
}
