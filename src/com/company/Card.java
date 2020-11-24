package com.company;

public class Card {

    private String suite;
    private String value;

    public Card(String suite, String value) {
        this.suite = suite;
        this.value = value;
    }

    public String getSuite() {
        return suite;
    }

    public String getValue() {
        return value;
    }

    public String getCard(){
        return String.format("%s of %s",getValue(), getSuite());
    }
}