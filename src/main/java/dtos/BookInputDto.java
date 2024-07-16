package dtos;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public record BookInputDto(UUID author_id, String title,
                           LocalDate publicationDate) implements Serializable {
}
