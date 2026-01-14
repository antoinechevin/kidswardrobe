package com.gaptextile.domain;

public enum Seasonality {
    WINTER("Hiver", "❄️"),
    SUMMER("Été", "☀️"),
    MID_SEASON("Mi-saison", "⛅"),
    ALL_YEAR("Toute l'année", "📅");

    private final String label;
    private final String icon;

    Seasonality(String label, String icon) {
        this.label = label;
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public String getIcon() {
        return icon;
    }
}
