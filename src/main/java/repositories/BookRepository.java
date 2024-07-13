package repositories;

import entities.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookRepository implements PanacheRepositoryBase<Book, UUID> {
    public Book update(Book book) {
        Book merge = getEntityManager().merge(book);
        persist(merge);
        return merge;
    }

    public List<Book> findByTitle(String title) {
        return find("SELECT a FROM Book a WHERE a.title = :title", Parameters.with("title", title)).list();
    }
}
