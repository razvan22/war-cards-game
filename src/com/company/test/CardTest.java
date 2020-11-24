package com.company.test;

import com.company.Card;
import org.junit.jupiter.api.*;




class CardTest {
    Card card = new Card();

    @Test
    public void testConstructor(){
        System.out.println("=== testConstructor ===");
        Card card = new Card("suite","value");
        Assertions.assertNotNull(card.getValue());
        Assertions.assertNotNull(card.getSuite());
    }

    @Test
    public void testGetSuite() {
        System.out.println("=== testGetSuite ===");
        Assertions.assertNotNull(card.getSuite());
    }


    @Test
    public void testGetValue(){
        System.out.println("=== testGetValue ===");
        Assertions.assertNotNull(card.getValue());
    }


    @Test
    public void testGetCard(){
        System.out.println("=== testGetCard ===");
        Assertions.assertNotNull(card.getCard());

    }




}
