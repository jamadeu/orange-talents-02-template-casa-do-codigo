package br.com.zup.casadocodigo.costumer.dto;

import br.com.zup.casadocodigo.costumer.entity.Costumer;
import br.com.zup.casadocodigo.country.entity.Country;
import br.com.zup.casadocodigo.shared.validator.annotation.CpfCnpj;
import br.com.zup.casadocodigo.shared.validator.annotation.FieldUnique;
import br.com.zup.casadocodigo.state.entity.State;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewCostumerRequest {

    @NotEmpty
    @Email
    @FieldUnique(message = "Email must be unique", fieldName = "email", domainClass = Costumer.class)
    private String email;
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @CpfCnpj(message = "Document invalid")
    @FieldUnique(message = "Document must be unique", fieldName = "document", domainClass = Costumer.class)
    private String document;
    @NotEmpty
    private String address;
    @NotEmpty
    private String complement;
    @NotEmpty
    private String city;
    @NotNull
    private Long countryId;
    private Long stateId;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String zipCode;


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

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Costumer toModel(EntityManager manager) {
        Country country = manager.find(Country.class, countryId);
        State state = null;
        if(stateId != null){
            state = manager.find(State.class, stateId);
        }
        return new Costumer(
                email, name, lastName, document, address, complement, city, country, state, phone, zipCode);
    }
}
