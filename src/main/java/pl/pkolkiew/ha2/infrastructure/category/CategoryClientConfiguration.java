package pl.pkolkiew.ha2.infrastructure.category;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pkolkiew.ha2.article.domain.ports.CategoryTreeClient;

/**
 * @author pkolkiew
 * Created 7/11/2020
 */
@Configuration
class CategoryClientConfiguration {

    @Bean
    CategoryTreeClient categoryTreeClient() {
        return new CategoryTreeRestTemplateClient();
    }

}
