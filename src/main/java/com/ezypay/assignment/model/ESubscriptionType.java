package com.ezypay.assignment.model;

public enum ESubscriptionType {

    DAILY("DAILY"), WEEKLY("WEEKLY"), MONTHLY("MONTHLY");

    private String value;

    ESubscriptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static boolean isValidSubscription(String value, String frequency) {
        for (ESubscriptionType v : ESubscriptionType.values()) {
            if (v.getValue().equalsIgnoreCase(value)) {
                if (value.equalsIgnoreCase(WEEKLY.getValue())) {
                    return Day.isValidDay(frequency);
                }
                if (value.equalsIgnoreCase(MONTHLY.getValue())) {
                    try {
                        int dayOfMonth = Integer.parseInt(frequency);
                        if (dayOfMonth > 0 && dayOfMonth <= 31) {
                            return true;
                        }
                        return false;
                    }
                    catch (NumberFormatException e) {
                        return false;
                    }
                }
                if (value.equalsIgnoreCase(DAILY.getValue())) {
                    return true;
                }

            }
        }
        return false;
    }
}
