package repositories;

import entities.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class BookRepository implements PanacheRepositoryBase<Book, UUID> {
    public Book update(Book book) {
        Book merge = getEntityManager().merge(book);
        persist(merge);
        return merge;
    }
}
