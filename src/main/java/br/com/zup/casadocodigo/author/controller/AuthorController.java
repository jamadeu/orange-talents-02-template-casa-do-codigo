package br.com.zup.casadocodigo.author.controller;

import br.com.zup.casadocodigo.author.dto.NewAuthorRequest;
import br.com.zup.casadocodigo.author.entity.Author;
import br.com.zup.casadocodigo.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isEmpty()) {
            return ResponseEntity.badRequest().body("Author not found");
        }
        return ResponseEntity.ok(optionalAuthor.get());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Author> create(@RequestBody @Valid NewAuthorRequest request, UriComponentsBuilder uriBuilder) {
        Author author = request.toModel();
        authorRepository.save(author);
        URI uri = uriBuilder.path("/author/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(author);
    }
}
