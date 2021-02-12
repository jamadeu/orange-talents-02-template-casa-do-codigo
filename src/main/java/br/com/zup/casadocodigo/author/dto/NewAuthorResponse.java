package br.com.zup.casadocodigo.author.dto;

import br.com.zup.casadocodigo.author.entity.Author;

public class NewAuthorResponse {


    private String name;
    private String email;
    private String description;

    public NewAuthorResponse(Author author) {
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
