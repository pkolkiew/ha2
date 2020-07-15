package pl.pkolkiew.ha2.article.domain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;
import pl.pkolkiew.ha2.article.domain.exceptions.AuthorNotFoundException;

import java.util.Optional;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

/**
 * Fasada to serwis aplikacyjny w nomenklaturze DDD
 * - integruje wiele zależności (repozytoria, fabryki, serwisy pomocnicze);
 * - zapewnia transakcyjność i bezpieczeństwo (np. poprzez adnotacje i AOP);
 * - integruje komponenty aplikacyjne (w tym wypadu pracujący w sesji, zalogowany użytkownik);
 * - orkiestruje obiekty domenowe.
 * źr. <u>https://bottega.com.pl/pdf/materialy/ddd/ddd1.pdf</u>
 *
 * @author pkolkiew
 * Created 7/10/2020
 */
@Slf4j
@AllArgsConstructor
public class ArticleFacade {
    private final ArticleUpdater updater;
    private final ArticlePublisher publisher;
    private final ArticleService articleService;
    private final AuthorService authorService;
    private final ArticleFactory factory = new ArticleFactory();

    public Page<ArticleDto> findAll(Pageable pageable) {
        Page<ArticleEntity> all = articleService.findAll(pageable);
        return factory.dto(all);
    }

    public ArticleDto show(String title) {
        nonNull(title);
        ArticleEntity entity = articleService.findOne(title);
        ArticleDto article = entity.dto();
        return article;
    }

    @Transactional
    public void add(ArticleDto articleDto) {
        requireNonNull(articleDto);
        AuthorEntity authorEntity = authorService.findOneById(articleDto.getAuthorId());

        ArticleEntity articleEntity = factory.from(articleDto, authorEntity);
        articleService.save(articleEntity);
    }

    /**
     * To jest do wywalenia do własnej domeny, na potrzeby przykładu zostało zaimplementowane tutaj
     * @param authorId
     * @param authorDto
     */
    public void add(AuthorId authorId, AuthorDto authorDto) {
        requireNonNull(authorDto);
        AuthorEntity authorEntity = factory.from(authorId, null, authorDto);
        authorService.add(authorEntity);
    }

}
