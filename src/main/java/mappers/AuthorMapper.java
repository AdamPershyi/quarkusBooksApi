package mappers;

import dtos.AuthorDto;
import dtos.AuthorInputDto;
import entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface AuthorMapper {
    Author toEntity(AuthorInputDto authorInputDto);

    AuthorDto toDto(Author author);


    List<AuthorDto> toListDtos(List<Author> authors);

    void updateAuthor(@MappingTarget Author author, AuthorInputDto authorInputDto);
}