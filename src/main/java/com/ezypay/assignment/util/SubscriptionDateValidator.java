package com.ezypay.assignment.util;


import com.ezypay.assignment.model.WSubscriptionDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;




public class SubscriptionDateValidator implements ConstraintValidator<ValidSubscriptionDate, WSubscriptionDate> {

    @Override
    public boolean isValid(WSubscriptionDate wSubscriptionDate, ConstraintValidatorContext constraintValidatorContext) {
        return check(wSubscriptionDate);
    }

    public boolean check(WSubscriptionDate wSubscriptionDate) {
        System.out.println(wSubscriptionDate.toString());
        LocalDate startDate = LocalDate.parse(wSubscriptionDate.getSubscriptionStartDate());
        LocalDate endDate = LocalDate.parse(wSubscriptionDate.getSubscriptionEndDate());

        if (endDate.isBefore(startDate)) {
            return false;
        }
        long monthsBetween = ChronoUnit.MONTHS.between(YearMonth.from(startDate), YearMonth.from(endDate));
        if (monthsBetween < 3) {
            return true;
        }

        return false;

    }
}
