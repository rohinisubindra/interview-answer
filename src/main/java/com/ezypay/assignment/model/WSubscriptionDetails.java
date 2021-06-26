package com.ezypay.assignment.model;



import com.ezypay.assignment.util.WSubscriptionDetailsDeserializer;
import com.ezypay.assignment.util.ValidSubscriptionDate;
import com.ezypay.assignment.util.ValidSubscriptionType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.Min;
import java.io.Serializable;



public class WSubscriptionDetails implements Serializable {

    @Min(10)
    private double amount;
    @ValidSubscriptionType
    private WSubscriptionType wSubscriptionType;
    @ValidSubscriptionDate
    private WSubscriptionDate wSubscriptionDate;

    public WSubscriptionDetails() {
    }

    public WSubscriptionDetails(double amount, WSubscriptionType wSubscriptionType, WSubscriptionDate wSubscriptionDate) {
        this.amount = amount;
        this.wSubscriptionType = wSubscriptionType;
        this.wSubscriptionDate = wSubscriptionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public WSubscriptionType getwSubscriptionType() {
        return wSubscriptionType;
    }

    public void setwSubscriptionType(WSubscriptionType wSubscriptionType) {
        this.wSubscriptionType = wSubscriptionType;
    }

    public WSubscriptionDate getwSubscriptionDate() {
        return wSubscriptionDate;
    }

    public void setwSubscriptionDate(WSubscriptionDate wSubscriptionDate) {
        this.wSubscriptionDate = wSubscriptionDate;
    }


    @Override
    public String toString() {
        return "WSubscriptionDetails{" + "amount=" + amount + ", wSubscriptionType=" + wSubscriptionType + ", wSubscriptionDate=" +
               wSubscriptionDate + '}';
    }
}
