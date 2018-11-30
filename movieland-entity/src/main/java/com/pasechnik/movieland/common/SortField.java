package com.pasechnik.movieland.common;

public enum SortField {
    PRICE("price"),
    RATING("rating");

    private String value;

    public String value() {
        return value;
    }

    SortField(String value) {
        this.value = value;
    }
    public static SortField getByName(String name) {
        for (SortField sortField : values()) {
            if (sortField.value.equalsIgnoreCase(name.trim())) {
                return sortField;
            }
        }
        throw new IllegalArgumentException("No sort type with name: " + name);
    }
}
