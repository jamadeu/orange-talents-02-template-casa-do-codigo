package br.com.zup.casadocodigo.author.controller;

import br.com.zup.casadocodigo.author.dto.NewAuthorRequest;
import br.com.zup.casadocodigo.author.entity.Author;
import br.com.zup.casadocodigo.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Author> create(@RequestBody @Valid NewAuthorRequest request) {
        Author author = request.toModel();
        authorRepository.save(author);
        return ResponseEntity.ok(author);
    }
}
