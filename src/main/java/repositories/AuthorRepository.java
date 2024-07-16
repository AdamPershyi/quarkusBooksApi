package repositories;
import entities.Author;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AuthorRepository implements PanacheRepositoryBase<Author, UUID> {
    public Author update(Author author) {
        Author merge = getEntityManager().merge(author);
        persist(merge);
        return merge;
    }

    public List<Author> findByName(String name) {
        return find("SELECT a FROM Author a WHERE a.name = ?1",name).list();
    }

}
