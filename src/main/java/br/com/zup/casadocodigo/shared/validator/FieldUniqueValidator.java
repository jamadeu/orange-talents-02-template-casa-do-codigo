package br.com.zup.casadocodigo.shared.validator;

import br.com.zup.casadocodigo.shared.validator.annotation.FieldUnique;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class FieldUniqueValidator implements ConstraintValidator<FieldUnique, Object> {
    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(FieldUnique params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + " = :value");
        query.setParameter("value", value);
        List<?> resultList = query.getResultList();
        return resultList.isEmpty();
    }
}
