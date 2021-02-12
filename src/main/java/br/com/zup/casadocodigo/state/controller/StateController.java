package br.com.zup.casadocodigo.state.controller;

import br.com.zup.casadocodigo.state.dto.NewStateRequest;
import br.com.zup.casadocodigo.state.dto.StateResponse;
import br.com.zup.casadocodigo.state.entity.State;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/state")
public class StateController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        State state = manager.find(State.class, id);
        if (state == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new StateResponse(state));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<StateResponse> create(@RequestBody @Valid NewStateRequest request, UriComponentsBuilder uriBuilder) {
        State state = request.toModel(manager);
        manager.persist(state);
        URI uri = uriBuilder.path("/country/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateResponse(state));
    }
}
