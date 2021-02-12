package br.com.zup.casadocodigo.shared.validator.annotation;

import br.com.zup.casadocodigo.shared.validator.EmailUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {EmailUniqueValidator.class})
public @interface EmailUnique {
    String message() default "EmailUnique.message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
