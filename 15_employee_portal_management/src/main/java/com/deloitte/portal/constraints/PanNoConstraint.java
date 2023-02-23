package com.deloitte.portal.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PanNoValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PanNoConstraint {
    String message() default "Please input valid Pan #";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
