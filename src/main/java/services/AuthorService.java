package services;

import dtos.AuthorDto;
import dtos.AuthorInputDto;
import entities.Author;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mappers.AuthorMapper;
import repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AuthorService {
    @Inject
    AuthorMapper authorMapper;
    @Inject
    AuthorRepository authorRepository;

    @Transactional
    public AuthorDto createAuthor(AuthorInputDto authorInputDto) {
        Author entity = authorMapper.toEntity(authorInputDto);
        authorRepository.persist(entity);
        return authorMapper.toDto(entity);
    }

    @Transactional
    public AuthorDto updateAuthor(AuthorInputDto authorInputDto, UUID authorId) {
        Author author = authorById(authorId);
        authorMapper.updateAuthor(author, authorInputDto);
        Author updateAuthor = authorRepository.update(author);
        return authorMapper.toDto(updateAuthor);

    }

    public Author authorById(UUID authorId) {
        return authorRepository.findById(authorId);
    }

    public List<AuthorDto> getAuthorByName(List<AuthorInputDto> authorInputDto) {
        List<AuthorInputDto> authorWithoutName = authorInputDto.stream()
                .filter(authorInputDto1 -> authorInputDto1.name() == null)
                .toList();

        if (!authorWithoutName.isEmpty()) {
            throw new RuntimeException("dai name");
        }

        List<Author> matchAuthor = new ArrayList<>();
        for (AuthorInputDto authorInputDto1 : authorInputDto) {
            List<Author> byName = authorRepository.findByName(authorInputDto1.name());
            matchAuthor.addAll(byName);
        }
        return authorMapper.toListDtos(matchAuthor);

    }

    public List<AuthorDto> getAuthors() {
        List<Author> authors = authorRepository.listAll();
        return authorMapper.toListDtos(authors);
    }


    public AuthorDto getAuthorById(UUID id) {
        Author authorById = findAuthorById(id);
        return authorMapper.toDto(authorById);
    }

    private Author findAuthorById(UUID id) {

        return authorRepository.findById(id);
    }
}
