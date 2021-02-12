package br.com.zup.casadocodigo.country.controller;

import br.com.zup.casadocodigo.country.dto.CountryResponse;
import br.com.zup.casadocodigo.country.dto.NewCountryRequest;
import br.com.zup.casadocodigo.country.entity.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/country")
public class CountryController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Country country = manager.find(Country.class, id);
        if (country == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new CountryResponse(country));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CountryResponse> create(@RequestBody @Valid NewCountryRequest request, UriComponentsBuilder uriBuilder) {
        Country country = request.toModel();
        manager.persist(country);
        URI uri = uriBuilder.path("/country/{id}").buildAndExpand(country.getId()).toUri();
        return ResponseEntity.created(uri).body(new CountryResponse(country));
    }
}
