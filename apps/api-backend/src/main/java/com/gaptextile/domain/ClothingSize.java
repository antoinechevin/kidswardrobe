package com.gaptextile.domain;

public enum ClothingSize {
    SIZE_1M("1M"),
    SIZE_3M("3M"),
    SIZE_6M("6M"),
    SIZE_9M("9M"),
    SIZE_12M("12M"),
    SIZE_18M("18M"),
    SIZE_24M("24M"),
    SIZE_36M("36M"),
    SIZE_4A("4A"),
    SIZE_6A("6A"),
    SIZE_8A("8A"),
    SIZE_10A("10A"),
    SIZE_12A("12A");

    private final String label;

    ClothingSize(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static ClothingSize fromLabel(String label) {
        for (ClothingSize size : values()) {
            if (size.label.equalsIgnoreCase(label)) {
                return size;
            }
        }
        throw new IllegalArgumentException("Invalid clothing size: " + label);
    }
}
