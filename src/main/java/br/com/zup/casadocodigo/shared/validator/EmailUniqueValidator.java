package br.com.zup.casadocodigo.shared.validator;

import br.com.zup.casadocodigo.author.repository.AuthorRepository;
import br.com.zup.casadocodigo.shared.validator.annotation.EmailUnique;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !authorRepository.existsAuthorByEmail(value);
    }
}
