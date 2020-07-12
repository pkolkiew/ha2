package pl.pkolkiew.ha2.article.domain


import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import pl.pkolkiew.ha2.article.domain.dto.ArticleDto
import spock.lang.Specification

/**
 * @author pkolkiew* Created 7/11/2020
 */
class ArticleFacadeTest extends Specification {
    ArticleFacade facade = new ArticleConfiguration().articleFacade(new InMemoryArticleRepository())

    ArticleDto flora = createArticleDto("flora", "Kwiatki i inne drzewka")
    ArticleDto fauna = createArticleDto("fauna", "Psy i koty")

    def "should add article"() {
        when: "we add an article"
            facade.add(flora)

        then: "system has an article"
            facade.show(flora.titleShort).titleShort == flora.titleShort
    }

    def "should list articles"() {
        given: "we have two articles in system"
            facade.add(flora)
            facade.add(fauna)

        when: "we ask for all articles"
            PageImpl<ArticleDto> foundArticles = facade.findAll(new PageRequest(0,10, Sort.unsorted()))

        then: "system returns articles we have added"
            foundArticles.getContent().contains(flora)
            foundArticles.contains(fauna)
    }


    private ArticleDto createArticleDto(String title, String content) {
        return ArticleDto.builder().titleShort(title).content(content).build()
    }
}
