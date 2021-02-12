package br.com.zup.casadocodigo.category.dto;

import br.com.zup.casadocodigo.category.entity.Category;
import br.com.zup.casadocodigo.shared.validator.annotation.FieldUnique;

import javax.validation.constraints.NotEmpty;

public class NewCategoryRequest {
    @NotEmpty
    @FieldUnique(message = "Category already exists", domainClass = Category.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(name);
    }
}
