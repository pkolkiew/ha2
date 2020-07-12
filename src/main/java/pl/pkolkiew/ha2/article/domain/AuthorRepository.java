package pl.pkolkiew.ha2.article.domain;

import org.springframework.data.repository.Repository;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import java.util.Optional;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
interface AuthorRepository extends Repository<AuthorEntity, Long> {

    Optional<AuthorEntity> findOneById(AuthorId authorId);

}
