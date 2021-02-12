package br.com.zup.casadocodigo.author.dto;

import br.com.zup.casadocodigo.author.entity.Author;
import br.com.zup.casadocodigo.shared.validator.annotation.EmailUnique;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NewAuthorRequest {

    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    @EmailUnique(message = "Email already in use")
    private String email;
    @NotEmpty
    @Size(max = 400)
    private String description;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }
}
