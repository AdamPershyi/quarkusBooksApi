package dtos;
import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link entities.Author}
 */
public record AuthorDto(UUID id, String name,
                        String bio) implements Serializable {
}