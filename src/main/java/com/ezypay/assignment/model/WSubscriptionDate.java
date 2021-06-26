package com.ezypay.assignment.model;

import java.io.Serializable;


public class WSubscriptionDate implements Serializable {
    private String subscriptionStartDate;
    private String subscriptionEndDate;

    public WSubscriptionDate() {
    }

    public WSubscriptionDate(String subscriptionStartDate, String subscriptionEndDate) {
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionEndDate = subscriptionEndDate;
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
        return "WSubscriptionDate{" + "subscriptionStartDate='" + subscriptionStartDate + '\'' + ", subscriptionEndDate='" +
               subscriptionEndDate + '\'' + '}';
    }
}
