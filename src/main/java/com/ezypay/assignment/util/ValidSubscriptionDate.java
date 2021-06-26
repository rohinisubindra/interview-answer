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
@Constraint(validatedBy = SubscriptionDateValidator.class)
@Documented
public @interface ValidSubscriptionDate {

    String message() default "Subscription End Date should be max 3 months only or End date cannot be before start date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
