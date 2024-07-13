package resouces;

import dtos.BookDto;
import dtos.BookInputDto;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import services.BookService;

import java.util.List;
import java.util.UUID;

@GraphQLApi
public class BookResource {
    @Inject
    BookService bookService;


    @Mutation("createBook")
    public BookDto createBook(BookInputDto bookInputDto) {
        return bookService.createBook(bookInputDto);

    }

    @Mutation("updateBook")
    public BookDto updateBook(BookInputDto bookInputDto, UUID bookId) {
        return bookService.updateBook(bookInputDto, bookId);
    }
@Query("getBooks")
public List<BookDto> getBooks(){
        return bookService.getBooks();

}

@Query("getBook")
    public BookDto getBook(UUID id){
        return bookService.getBook(id);
}



}
