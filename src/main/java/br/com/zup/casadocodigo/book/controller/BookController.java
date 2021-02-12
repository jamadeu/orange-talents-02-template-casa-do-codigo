package br.com.zup.casadocodigo.book.controller;

import br.com.zup.casadocodigo.book.dto.NewBookRequest;
import br.com.zup.casadocodigo.book.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/book")
public class BookController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Book book = manager.find(Book.class, id);
        if (book == null) {
            return ResponseEntity.badRequest().body("Book not found");
        }
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        Query query = manager.createQuery("select b.id, b.title from Book b");
        return ResponseEntity.ok(query.getResultList());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Book> create(@RequestBody @Valid NewBookRequest request, UriComponentsBuilder uriBuilder) {
        Book book = request.toModel(manager);
        manager.persist(book);
        URI uri = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(book);
    }
}
