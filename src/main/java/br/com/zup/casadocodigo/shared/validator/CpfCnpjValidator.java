package br.com.zup.casadocodigo.shared.validator;

import br.com.zup.casadocodigo.shared.validator.annotation.CpfCnpj;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {
    private String cpf = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})";
    private String cnpj = "([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches(cpf) || value.matches(cnpj);
    }
}
