package br.com.zup.casadocodigo.category.dto;

import br.com.zup.casadocodigo.category.entity.Category;

public class NewCategoryResponse {

    private String name;

    public NewCategoryResponse(Category category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }
}
