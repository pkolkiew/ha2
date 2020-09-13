package pl.pkolkiew.ha2.bio.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.pkolkiew.ha2.infrastructure.shared.aggregates.AggregateId;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
interface BioRepository {
    Optional<BioEntity> findOneById(AggregateId bioId);

    void save(BioEntity bioEntity);

    boolean checkIfExistsByNameAndSurname(String name, String surname);
}

@AllArgsConstructor
class BioSpringRepository implements BioRepository {

    private final BioSpringCrudRepository crudRepository;

    @Override
    public Optional<BioEntity> findOneById(AggregateId bioId) {
        return crudRepository.findById(bioId.getId());
    }

    @Override
    public void save(BioEntity bioEntity) {
        crudRepository.save(bioEntity);
    }

    @Override
    public boolean checkIfExistsByNameAndSurname(String name, String surname) {
        return crudRepository.checkIfExistsByNameAndSurname(name, surname);
    }

    interface BioSpringCrudRepository extends CrudRepository<BioEntity, Long> {

        @Query("SELECT CASE WHEN count(b) > 0 THEN true ELSE false END FROM bio b WHERE b.name =:name AND b.surname=:surname")
        boolean checkIfExistsByNameAndSurname(String name, String surname);
    }

}

class InMemoryBioRepository implements BioRepository {

    private final ConcurrentHashMap<Long, BioEntity> map = new ConcurrentHashMap<>();

    @Override
    public Optional<BioEntity> findOneById(AggregateId bioId) {
        return Optional.of(map.get(bioId.getId()));
    }

    @Override
    public void save(BioEntity bioEntity) {
        map.put(bioEntity.getBioId().getId(), bioEntity);
    }

    @Override
    public boolean checkIfExistsByNameAndSurname(String name, String surname) {
        return map.values().stream()
                .filter(x -> x.getName().equalsIgnoreCase(name) && x.getSurname().equalsIgnoreCase(surname))
                .findAny().isEmpty();
    }
}
