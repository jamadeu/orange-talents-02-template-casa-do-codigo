package br.com.zup.casadocodigo.category.controller;

import br.com.zup.casadocodigo.category.dto.NewCategoryRequest;
import br.com.zup.casadocodigo.category.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Category category = manager.find(Category.class, id);
        if (category == null) {
            return ResponseEntity.badRequest().body("Category not found");
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Category> create(@RequestBody @Valid NewCategoryRequest request, UriComponentsBuilder uriBuilder) {
        Category category = request.toModel();
        manager.persist(category);
        URI uri = uriBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(category);
    }
}
