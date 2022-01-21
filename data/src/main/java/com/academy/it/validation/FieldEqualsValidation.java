package com.academy.it.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldEqualsValidation implements ConstraintValidator<FieldEquals, Object> {

    private String field;
    private String equalsTo;

    @Override
    public void initialize(FieldEquals constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.equalsTo = constraintAnnotation.equalsTo();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(equalsTo);

        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}
