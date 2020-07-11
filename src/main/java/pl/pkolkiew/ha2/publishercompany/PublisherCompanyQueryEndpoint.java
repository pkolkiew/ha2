package pl.pkolkiew.ha2.publishercompany;

import pl.pkolkiew.ha2.publishercompany.domain.PublisherCompanyFacade;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
class PublisherCompanyQueryEndpoint {
    private final PublisherCompanyFacade facade;

    PublisherCompanyQueryEndpoint(PublisherCompanyFacade facade) {
        this.facade = facade;
    }


}
