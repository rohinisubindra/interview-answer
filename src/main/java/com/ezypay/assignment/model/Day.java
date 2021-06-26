package com.ezypay.assignment.model;

public enum Day {

    SUNDAY("SUNDAY"), MONDAY("MONDAY"), TUESDAY("TUESDAY"), WEDNESDAY("WEDNESDAY"), THURSDAY("THURSDAY"), FRIDAY("FRIDAY"), SATURDAY(
            "SATURDAY");

    private String value;

    Day(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static boolean isValidDay(String value) {
        for (Day v : values()) {
            if (v.getValue().equalsIgnoreCase(value)) return true;
        }
        return false;
    }
}