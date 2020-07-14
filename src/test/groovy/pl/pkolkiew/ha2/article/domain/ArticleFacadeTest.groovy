package pl.pkolkiew.ha2.article.domain


import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto
import pl.pkolkiew.ha2.article.domain.dto.AuthorDto
import pl.pkolkiew.ha2.article.domain.dto.AuthorId
import spock.lang.Specification

/**
 * @author pkolkiew* Created 7/11/2020
 */
class ArticleFacadeTest extends Specification {
    ArticleFacade facade = new ArticleConfiguration().articleFacade()

    AuthorDto author1 = AuthorDto.builder().name("author1").build()
    AuthorDto author2 = AuthorDto.builder().name("author2").build()
    AuthorId authorId1 = AuthorId.of(3L)
    AuthorId authorId2 = AuthorId.of(4L)

    ArticleDto flora = createArticleDto("flora", "Kwiatki i inne drzewka", authorId1)
    ArticleDto fauna = createArticleDto("fauna", "Psy i koty", authorId2)

    def "should add article"() {
        when: "we add an author1, author2 and we add an article"
            facade.add(authorId1, author1)
            facade.add(authorId2, author2)
            facade.add(flora)

        then: "system has an article"
            facade.show(flora.titleLong).titleLong == flora.titleLong
    }

    def "should list articles"() {
        given: "we have two articles and two authors in system"
            facade.add(authorId1, author1)
            facade.add(authorId2, author2)
            facade.add(flora)
            facade.add(fauna)

        when: "we ask for all articles"
            PageImpl<ArticleDto> foundArticles = facade.findAll(new PageRequest(0,10, Sort.unsorted()))

        then: "system returns articles we have added"
            foundArticles.getContent().stream().anyMatch({ str -> str == flora })
            foundArticles.getContent().stream().anyMatch({ str -> str == fauna })
    }


    private ArticleDto createArticleDto(String title, String content, AuthorId authorId) {
        return ArticleDto.builder().titleLong(title).content(content)
                .authorId(authorId)
                .build()
    }
}
