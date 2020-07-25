package pl.pkolkiew.ha2.author.domain


import spock.lang.Specification

class AuthorFacadeTest extends Specification {

    AuthorFacade facade = new AuthorConfiguration().authorFacade()
}
