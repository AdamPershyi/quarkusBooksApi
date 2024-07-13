package mappers;

import dtos.AuthorDto;
import dtos.AuthorInputDto;
import entities.Author;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface AuthorMapper {
    Author toEntity(AuthorInputDto authorInputDto);

    AuthorDto toDto(Author author);


    List<AuthorDto> toListDtos(List<Author> authors);

    void updateAuthor(@MappingTarget Author author, AuthorInputDto authorInputDto);
}