package com.ezypay.assignment.util;



import com.ezypay.assignment.model.ESubscriptionType;
import com.ezypay.assignment.model.WSubscriptionType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;




public class SubscriptionTypeValidator implements ConstraintValidator<ValidSubscriptionType, WSubscriptionType> {

    @Override
    public boolean isValid(WSubscriptionType subscriptionType, ConstraintValidatorContext constraintValidatorContext) {
        return ESubscriptionType.isValidSubscription(subscriptionType.getSubscriptionType(), subscriptionType.getFrequencyDetails());
    }

}
