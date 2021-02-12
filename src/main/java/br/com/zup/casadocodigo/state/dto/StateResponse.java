package br.com.zup.casadocodigo.state.dto;

import br.com.zup.casadocodigo.country.dto.CountryResponse;
import br.com.zup.casadocodigo.state.entity.State;

public class StateResponse {

    private String name;
    private CountryResponse country;

    public StateResponse(State state) {
        this.name = state.getName();
        this.country = new CountryResponse(state.getCountry());
    }

    public String getName() {
        return name;
    }

    public CountryResponse getCountry() {
        return country;
    }
}
