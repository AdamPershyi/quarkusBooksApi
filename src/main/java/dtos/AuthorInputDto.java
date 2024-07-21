package dtos;
import java.io.Serializable;

public record AuthorInputDto(String name,
                             String bio) implements Serializable {
}
