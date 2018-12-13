package com.pasechnik.movieland.common;

public enum CurrencyType {
    USD("USD"),
    EUR("EUR");

    private String value;

    CurrencyType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static CurrencyType getByName(String name) {
        for (CurrencyType currencyType : values()) {
            if (currencyType.value.equalsIgnoreCase(name.trim())) {
                return currencyType;
            }
        }
        throw new IllegalArgumentException("No currency type with name: " + name);
    }
}
