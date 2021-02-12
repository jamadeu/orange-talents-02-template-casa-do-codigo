package br.com.zup.casadocodigo.category.controller;

import br.com.zup.casadocodigo.category.dto.NewCategoryRequest;
import br.com.zup.casadocodigo.category.entity.Category;
import br.com.zup.casadocodigo.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            return ResponseEntity.badRequest().body("Category not found");
        }
        return ResponseEntity.ok(optionalCategory.get());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Category> create(@RequestBody @Valid NewCategoryRequest request, UriComponentsBuilder uriBuilder) {
        Category category = request.toModel();
        categoryRepository.save(category);
        URI uri = uriBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(category);
    }
}
