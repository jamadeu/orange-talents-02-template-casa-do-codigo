package br.com.zup.casadocodigo.country.dto;

import br.com.zup.casadocodigo.country.entity.Country;

public class CountryResponse {

    private String name;

    public CountryResponse(Country country) {
        this.name = country.getName();
    }

    public String getName() {
        return name;
    }
}
