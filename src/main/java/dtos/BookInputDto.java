package dtos;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public record BookInputDto(UUID author_id, @Size(max = 255) String title,
                           LocalDate publicationDate) implements Serializable {
}
