package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.dto.NewAuthorRequest;
import br.com.zup.casadocodigo.entity.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody @Valid NewAuthorRequest request) {
        Author author = request.toModel();
        author.create(authorRepository);
        return ResponseEntity.ok(author);
    }
}
