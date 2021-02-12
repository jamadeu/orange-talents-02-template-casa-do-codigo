package br.com.zup.casadocodigo.author.controller;

import br.com.zup.casadocodigo.author.dto.NewAuthorRequest;
import br.com.zup.casadocodigo.author.dto.NewAuthorResponse;
import br.com.zup.casadocodigo.author.entity.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Author author = manager.find(Author.class, id);
        if (author == null) {
            return ResponseEntity.badRequest().body("Author not found");
        }
        return ResponseEntity.ok(new NewAuthorResponse(author));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Author> create(@RequestBody @Valid NewAuthorRequest request, UriComponentsBuilder uriBuilder) {
        Author author = request.toModel();
        manager.persist(author);
        URI uri = uriBuilder.path("/author/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(author);
    }
}
