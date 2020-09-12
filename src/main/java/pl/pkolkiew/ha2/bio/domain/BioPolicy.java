package pl.pkolkiew.ha2.bio.domain;


/**
 * @author pkolkiew
 * Created 9/6/2020
 */
interface BioPolicy {
}

class AddNewBioPolicy implements BioPolicy {

    private final String policyName;

    AddNewBioPolicy(String policyName) {
        this.policyName = policyName;
    }
}