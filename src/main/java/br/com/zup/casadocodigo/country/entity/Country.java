package br.com.zup.casadocodigo.country.entity;

import br.com.zup.casadocodigo.state.entity.State;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<State> states;

    public Country() {
    }

    public Country(@NotEmpty String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<State> getStates() {
        return states;
    }
}
