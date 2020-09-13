package pl.pkolkiew.ha2.bio.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Configuration
class BioConfiguration {

    BioRepository inMemBioRepository() {
        return new InMemoryBioRepository();
    }

    @Bean
    BioRepository bioRepository(BioSpringRepository.BioSpringCrudRepository bioSpringCrudRepository) {
        return new BioSpringRepository(bioSpringCrudRepository);
    }

    @Bean
    BioFactory bioFactory(BioRepository bioRepository) {
        return new BioFactory(bioRepository, new AddNewBioPolicy("TEST"));
    }

}
