package com.pasechnik.movieland.common;

public enum SortType {
    DESC("desc"),
    ASC("asc");

    private String value;

    SortType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static SortType getByName(String name) {
        for (SortType sortType : values()) {
            if (sortType.value.equalsIgnoreCase(name.trim())) {
                return sortType;
            }
        }
        throw new IllegalArgumentException("No sort type with name: " + name);
    }
}
