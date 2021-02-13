package br.com.zup.casadocodigo.shared.validator.annotation;

import br.com.zup.casadocodigo.shared.validator.CpfCnpjValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {CpfCnpjValidator.class})
@Documented
public @interface CpfCnpj {
    String message() default "CpfCnpj.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
