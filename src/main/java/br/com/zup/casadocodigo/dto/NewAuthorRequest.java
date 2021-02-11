package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.entity.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NewAuthorRequest {

    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(max = 400)
    private String description;

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }
}
