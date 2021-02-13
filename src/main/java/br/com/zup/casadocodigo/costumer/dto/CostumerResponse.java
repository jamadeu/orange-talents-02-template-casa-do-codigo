package br.com.zup.casadocodigo.costumer.dto;

import br.com.zup.casadocodigo.costumer.entity.Costumer;
import br.com.zup.casadocodigo.country.dto.CountryResponse;
import br.com.zup.casadocodigo.state.dto.StateResponse;
import br.com.zup.casadocodigo.state.entity.State;

public class CostumerResponse {

    private String email;
    private String name;
    private String lastName;
    private String document;
    private String address;
    private String complement;
    private String city;
    private CountryResponse coutry;
    private StateResponse state = null;
    private String phone;
    private String zipCode;

    public CostumerResponse(Costumer costumer) {
        this.email = costumer.getEmail();
        this.name = costumer.getName();
        this.lastName = costumer.getLastName();
        this.document = costumer.getDocument();
        this.address = costumer.getAddress();
        this.complement = costumer.getComplement();
        this.city = costumer.getCity();
        this.coutry = new CountryResponse(costumer.getCountry());
        State state = costumer.getState();
        if (state != null) {
            this.state = new StateResponse(state);
        }
        this.phone = costumer.getPhone();
        this.zipCode = costumer.getZipCode();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public CountryResponse getCoutry() {
        return coutry;
    }

    public StateResponse getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }
}
