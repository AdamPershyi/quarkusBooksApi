package resouces;

import dtos.AuthorDto;
import dtos.AuthorInputDto;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import services.AuthorService;

import java.util.List;
import java.util.UUID;

@GraphQLApi
public class AuthorResource {
    @Inject
    AuthorService authorService;

    @Mutation("createAuthor")
    public AuthorDto createAuthor(AuthorInputDto authorInputDto) {
        return authorService.createAuthor(authorInputDto);
    }

    @Mutation("updateAuthor")
    public AuthorDto updateAuthor(AuthorInputDto authorInputDto, UUID authorId) {
        return authorService.updateAuthor(authorInputDto, authorId);
    }

    @Query("getAuthors")
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthors();
    }

    @Query("getAuthorById")
    public AuthorDto getAuthorById(UUID id) {
        return authorService.getAuthorById(id);
    }

    @Query("getAuthorByName")
    public List<AuthorDto> getAuthorByName(List<AuthorInputDto> authorInputDtos) {
        return authorService.getAuthorByName(authorInputDtos);
    }


}
