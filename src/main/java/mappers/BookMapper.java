package mappers;
import dtos.BookDto;
import dtos.BookInputDto;
import entities.Book;
import org.mapstruct.*;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface BookMapper {
    @Mapping(source = "author_id", target = "author.id")
    Book toEntity(BookInputDto bookDto);

    @Mapping(source = "author.id", target = "author_id")
    BookDto toDto(Book book);

    void updatedEntity(@MappingTarget Book book, BookInputDto bookInputDto);

    List<BookDto> toListDtos(List<Book> books);
}