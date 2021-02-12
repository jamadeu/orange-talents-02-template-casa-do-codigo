package br.com.zup.casadocodigo.shared.validator.annotation;

import br.com.zup.casadocodigo.shared.validator.ExistsIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {ExistsIdValidator.class})
@Documented
public @interface ExistsId {
    String message() default "ExistsId.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}
