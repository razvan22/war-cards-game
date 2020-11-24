package com.company;

import java.sql.Array;

public class Card {

    private final String suite;
    private final String value;

    public Card(String suite, String value) {
        this.suite = suite;
        this.value = value;
    }

    private String getSuite() {
        return suite;
    }

    private String getValue() {
        return value;
    }

    public String getCard(){
        return null;
    }
}

