package pl.pkolkiew.ha2.bio.domain;

import lombok.AllArgsConstructor;
import pl.pkolkiew.ha2.bio.domain.exceptions.BioAlreadyExistsException;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@AllArgsConstructor
class BioFactory {

    private final BioRepository bioRepository;
    private final BioPolicy bioPolicy;

    void createNewBio(String name, String surname) {
        checkIfBioCanBeCreated(name, surname);
        Bio bio = Bio.builder()
                .name(name)
                .surname(surname)
                .build();

    }

    void checkIfBioCanBeCreated(String name, String surname) {
        if (bioRepository.checkIfExistsByNameAndSurname(name, surname)) {
            throw new BioAlreadyExistsException(name, surname);
        }
    }
}
