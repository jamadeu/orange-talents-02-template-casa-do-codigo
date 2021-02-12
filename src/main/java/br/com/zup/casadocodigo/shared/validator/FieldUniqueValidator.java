package br.com.zup.casadocodigo.shared.validator;

import br.com.zup.casadocodigo.author.repository.AuthorRepository;
import br.com.zup.casadocodigo.category.repository.CategoryRepository;
import br.com.zup.casadocodigo.shared.validator.annotation.FieldUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldUniqueValidator implements ConstraintValidator<FieldUnique, String> {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.contains("@")) {
            return !authorRepository.existsAuthorByEmail(value);
        } else {
            return !categoryRepository.existsByName(value);
        }
    }
}
