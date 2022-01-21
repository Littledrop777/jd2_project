package com.academy.it.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Constraint(validatedBy = FieldEqualsValidation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldEquals {


    String message() default "Fields values does not equals!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();

    String equalsTo();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldEquals[] value();
    }
}
