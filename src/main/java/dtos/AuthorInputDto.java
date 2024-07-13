package dtos;

import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record AuthorInputDto(@Size(max = 255) String name,
                             String bio) implements Serializable {
}
