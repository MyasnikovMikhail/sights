package com.example.sights.domain;

public enum TypeSight {
    BUILDING("Building"),CONSTRUCTION("Construction"),MUSEUM("Museum"),MONUMENT("Monument"),RESERVE("Reserve");

    private final String displayText;

    TypeSight(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
