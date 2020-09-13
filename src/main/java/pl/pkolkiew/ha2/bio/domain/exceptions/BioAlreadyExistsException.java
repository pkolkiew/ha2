package pl.pkolkiew.ha2.bio.domain.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pkolkiew
 * Created 9/13/2020
 */
@Slf4j
public class BioAlreadyExistsException extends RuntimeException {
    public BioAlreadyExistsException(String name, String surname) {
        super("Bio for person with name: " + name + " and surname: " + surname + " not found", null, false, false);
    }
}
