package pl.pkolkiew.ha2.author.domain;

import pl.pkolkiew.ha2.article.domain.dto.AuthorDto;
import pl.pkolkiew.ha2.article.domain.dto.AuthorId;

import static java.util.Objects.requireNonNull;

class AuthorFactory {

    public AuthorEntity from(AuthorId authorId, PublisherCompanyId publisherCompanyId, AuthorDto authorDto) {
        requireNonNull(authorDto);
        return AuthorEntity.builder()
                .authorId(authorId.getAuthorId())
                .name(authorDto.getName())
                .publisherCompanyOwnerId(publisherCompanyId)
                .build();
    }
}
