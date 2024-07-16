package dtos;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link entities.Book}
 */
public record BookDto(UUID id, String title,
                      LocalDate publicationDate, UUID author_id) implements Serializable {
}