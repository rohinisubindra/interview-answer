package com.ezypay.assignment.model;

import java.io.Serializable;


public class WSubscriptionType implements Serializable {
    private String subscriptionType;
    private String frequencyDetails;

    public WSubscriptionType(String subscriptionType, String frequencyDetails) {
        this.subscriptionType = subscriptionType;
        this.frequencyDetails = frequencyDetails;
    }

    public WSubscriptionType() {
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getFrequencyDetails() {
        return frequencyDetails;
    }

    public void setFrequencyDetails(String frequencyDetails) {
        this.frequencyDetails = frequencyDetails;
    }

    @Override
    public String toString() {
        return "WSubscriptionType{" + "subscriptionType='" + subscriptionType + '\'' + ", frequencyDetails='" + frequencyDetails + '\'' +
               '}';
    }
}
