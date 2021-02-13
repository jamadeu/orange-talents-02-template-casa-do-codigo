package br.com.zup.casadocodigo.costumer.entity;

import br.com.zup.casadocodigo.country.entity.Country;
import br.com.zup.casadocodigo.state.entity.State;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String document;
    @NotEmpty
    private String address;
    @NotEmpty
    private String complement;
    @NotEmpty
    private String city;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String zipCode;

    @Deprecated
    public Costumer() {
    }


    public Costumer(@NotEmpty @Email String email, @NotEmpty String name, @NotEmpty String lastName, @NotEmpty String document, @NotEmpty String address, @NotEmpty String complement, @NotEmpty String city, @NotNull Country country, State state, @NotEmpty String phone, @NotEmpty String zipCode) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public Costumer(@NotEmpty @Email String email, @NotEmpty String name, @NotEmpty String lastName, @NotEmpty String document, @NotEmpty String address, @NotEmpty String complement, @NotEmpty String city, @NotNull Country country, @NotEmpty String phone, @NotEmpty String zipCode) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public Long getId() {
        return id;
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


    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }
}
