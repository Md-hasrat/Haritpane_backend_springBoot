package com.Haritpane.springBoot_haritpane_backend.enums;

public enum HpOfTractor {

    UNDER_20("Under_20"),
    BETWEEN_21_30("21-30"),
    BETWEEN_31_40("31-40"),
    BETWEEN_41_45("41-45"),
    BETWEEN_46_50("46-50"),
    ABOVE_50("Above_50");

    private final String value;

    HpOfTractor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}