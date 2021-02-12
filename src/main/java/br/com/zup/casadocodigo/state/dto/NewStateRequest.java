package br.com.zup.casadocodigo.state.dto;

import br.com.zup.casadocodigo.country.entity.Country;
import br.com.zup.casadocodigo.shared.validator.annotation.ExistsId;
import br.com.zup.casadocodigo.shared.validator.annotation.FieldUnique;
import br.com.zup.casadocodigo.state.entity.State;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewStateRequest {

    @NotEmpty
    @FieldUnique(message = "State already exists", domainClass = State.class, fieldName = "name")
    private String name;
    @NotNull
    @ExistsId(message = "Country not found", domainClass = Country.class, fieldName = "id")
    private Long countryId;

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toModel(EntityManager manager) {
        Country country = manager.find(Country.class, countryId);
        return new State(name, country);
    }
}
