package org.coalery.manager;

public enum Language {
    UNDEFINED(-1), KOREAN(0), ENGLISH(1);

    private int value;
    Language(int value) { this.value = value; }

    public int getValue() { return value; }
}
