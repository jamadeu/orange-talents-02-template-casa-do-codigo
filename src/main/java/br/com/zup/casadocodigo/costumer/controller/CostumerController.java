package br.com.zup.casadocodigo.costumer.controller;

import br.com.zup.casadocodigo.costumer.dto.CostumerResponse;
import br.com.zup.casadocodigo.costumer.dto.NewCostumerRequest;
import br.com.zup.casadocodigo.costumer.entity.Costumer;
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
@RequestMapping("/costumer")
public class CostumerController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    public ResponseEntity<CostumerResponse> findById(@PathVariable Long id) {
        Costumer costumer = manager.find(Costumer.class, id);
        if (costumer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new CostumerResponse(costumer));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid NewCostumerRequest request, UriComponentsBuilder uriBuilder) {
        Country country = manager.find(Country.class, request.getCountryId());
        if (!country.getStates().isEmpty() && request.getStateId() == null) {
            return ResponseEntity.badRequest().body("State id can't be null");
        }
        Costumer costumer = request.toModel(manager);
        manager.persist(costumer);
        URI uri = uriBuilder.path("/costumer/{id}").buildAndExpand(costumer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CostumerResponse(costumer));
    }
}
