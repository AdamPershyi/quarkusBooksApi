package services;
import dtos.BookDto;
import dtos.BookInputDto;
import entities.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mappers.BookMapper;
import repositories.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookService {
    @Inject
    BookMapper bookMapper;
    @Inject
    BookRepository bookRepository;

    @Transactional
    public BookDto createBook(BookInputDto bookInputDto) {
        Book entity = bookMapper.toEntity(bookInputDto);
        bookRepository.persist(entity);
        return bookMapper.toDto(entity);
    }

    @Transactional
    public BookDto updatedBook(BookInputDto bookInputDto, UUID bookId) {
        Book book = findBookById(bookId);
        bookMapper.updatedEntity(book, bookInputDto);
        Book updatedBook = bookRepository.update(book);
        return bookMapper.toDto(updatedBook);
    }

    private Book findBookById(UUID bookId) {
        return bookRepository.findById(bookId);
    }

    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.listAll();
        return bookMapper.toListDtos(books);
    }

    public BookDto getBook(UUID id) {
        Book bookById = findBookById(id);
        return bookMapper.toDto(bookById);
    }

    public List<BookDto> getBooksByTitle(List<BookInputDto> bookInputDtos) {
        List<BookInputDto> bookWithoutTitle = bookInputDtos.stream()
                .filter(bookInputDto -> bookInputDto.title() == null)
                .toList();
        if (!bookWithoutTitle.isEmpty()){
           throw new RuntimeException("Title is empty");
        }

        List<Book> booksMatch = new ArrayList<>();
        for (BookInputDto bookInputDto : bookInputDtos) {
            List<Book> byTitle = bookRepository.findByTitle(bookInputDto.title());
            booksMatch.addAll(byTitle);
        }
        return bookMapper.toListDtos(booksMatch);
    }
}
