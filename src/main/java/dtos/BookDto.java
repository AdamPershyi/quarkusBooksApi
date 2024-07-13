package dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link entities.Book}
 */
public record BookDto(UUID id, @Size(max = 255) String title,
                      LocalDate publicationDate,UUID author_id) implements Serializable {
}