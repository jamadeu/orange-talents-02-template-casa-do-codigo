package br.com.zup.casadocodigo.country.dto;

import br.com.zup.casadocodigo.country.entity.Country;
import br.com.zup.casadocodigo.shared.validator.annotation.FieldUnique;

import javax.validation.constraints.NotEmpty;

public class NewCountryRequest {

    @NotEmpty
    @FieldUnique(message = "Country already exists", domainClass = Country.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public Country toModel() {
        return new Country(name);
    }
}
