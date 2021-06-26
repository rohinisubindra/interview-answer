package com.ezypay.assignment.model;


public class SubscriptionDetails {

    private double amount;
    private String subscriptionType;
    private String frequencyDetails;
    private String subscriptionStartDate;
    private String subscriptionEndDate;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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


    public String getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public void setSubscriptionStartDate(String subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public String getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(String subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    @Override
    public String toString() {
        return "SubscriptionDetails{" + "amount=" + amount + ", subscriptionType='" + subscriptionType + '\'' + ", frequencyDetails='" +
               frequencyDetails + '\'' + ", subscriptionStartDate='" + subscriptionStartDate + '\'' + ", subscriptionEndDate='" +
               subscriptionEndDate + '\'' + '}';
    }
}
