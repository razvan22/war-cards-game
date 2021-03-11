package com.company.test;

import com.company.Card;
import org.junit.jupiter.api.*;




class CardTest {
    String suite = "hearts";
    String value = "7";
    Card card = new Card(suite, value);

    @Test
    public void testConstructor(){
        System.out.println("=== CardTest testConstructor ===");
        Assertions.assertNotNull(card.getValue());
        Assertions.assertNotNull(card.getSuit());
        Assertions.assertEquals(value, card.getValue());
        Assertions.assertEquals(suite, card.getSuit());
    }

    @Test
    public void testGetSuite() {
        System.out.println("=== testGetSuite ===");
        Assertions.assertNotNull(card.getSuit());
        Assertions.assertTrue(card.getSuit() instanceof String);
    }


    @Test
    public void testGetValue(){
        System.out.println("=== testGetValue ===");
        Assertions.assertNotNull(card.getValue());
        Assertions.assertTrue(card.getValue() instanceof String);

    }


    @Test
    public void testGetCard(){
        System.out.println("=== testGetCard ===");
        Assertions.assertNotNull(card.getCard());

    }
}
