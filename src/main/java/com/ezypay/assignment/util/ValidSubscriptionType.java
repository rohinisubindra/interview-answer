package com.ezypay.assignment.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = SubscriptionTypeValidator.class)
@Documented
public @interface ValidSubscriptionType {

    String message() default "failed while validating subscription type if weekly frequency should be within {monday....sunday} if monthly frquency should be [1-31]";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
