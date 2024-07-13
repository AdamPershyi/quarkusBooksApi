package dtos;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link entities.Author}
 */
public record AuthorDto(UUID id, @Size(max = 255) String name,
                        String bio) implements Serializable {
}