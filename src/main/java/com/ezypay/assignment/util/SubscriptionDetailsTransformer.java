package com.ezypay.assignment.util;



import com.ezypay.assignment.model.SubscriptionDetails;
import com.ezypay.assignment.model.WSubscriptionDetailsRest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;


public class SubscriptionDetailsTransformer implements Function<WSubscriptionDetailsRest, SubscriptionDetails> {
    private SimpleDateFormat originalDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public SubscriptionDetails apply(WSubscriptionDetailsRest wSubscriptionDetails) {
        SubscriptionDetails subscriptionDetails = new SubscriptionDetails();
        try {
            subscriptionDetails.setAmount(wSubscriptionDetails.getAmount());
            subscriptionDetails.setFrequencyDetails(wSubscriptionDetails.getwSubscriptionType().getFrequencyDetails());
            subscriptionDetails.setSubscriptionType(wSubscriptionDetails.getwSubscriptionType().getSubscriptionType());

            Date start = originalDateFormat.parse(wSubscriptionDetails.getwSubscriptionDate().getSubscriptionStartDate());
            Date end = originalDateFormat.parse(wSubscriptionDetails.getwSubscriptionDate().getSubscriptionEndDate());

            subscriptionDetails.setSubscriptionStartDate(targetDateFormat.format(start));
            subscriptionDetails.setSubscriptionEndDate(targetDateFormat.format(end));

        }
        catch (Exception e) {

        }
        return subscriptionDetails;
    }


}
