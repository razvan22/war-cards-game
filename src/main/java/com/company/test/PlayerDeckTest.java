package com.company.test;


import com.company.Card;
import com.company.CardsFetcher;
import com.company.PlayerDeck;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class PlayerDeckTest {

    CardsFetcher cardsFetcher = new CardsFetcher();
    PlayerDeck playerDeck;


    @Test
    public void constructorTest(){
        System.out.println("=== playerDeckConstructorTest ===");
        cardsFetcher.readCardsFromJsonFile();
        ArrayList<Card> cards = cardsFetcher.getCards();
        playerDeck  = new PlayerDeck(cards);

        Assertions.assertNotNull(playerDeck.drawCard());

        ArrayList<Card> unValidCards = new ArrayList<>();
        unValidCards.add(cards.get(0));
        unValidCards.add(cards.get(1));
        unValidCards.add(cards.get(2));

        var exception = Assertions.assertThrows(
                IllegalStateException.class,
                () ->  playerDeck = new PlayerDeck(unValidCards));
        Assertions.assertEquals("cards.size() should be 26", exception.getMessage());
    }

    @Test
    public void testDrawCard(){
        System.out.println("=== testDrawCard ===");
        cardsFetcher.readCardsFromJsonFile();
        ArrayList<Card> cards = cardsFetcher.getCards();
        playerDeck  = new PlayerDeck(cards);
        Assertions.assertNotNull(playerDeck.drawCard());
    }

    @Test
    public void testInsertCard(){
        System.out.println("=== testInsertCard ===");
        Card card = new Card("harts","1");
        cardsFetcher.readCardsFromJsonFile();
        ArrayList<Card> cards = cardsFetcher.getCards();
        playerDeck  = new PlayerDeck(cards);
        Assertions.assertTrue(playerDeck.insertCard(card));
    }

}
