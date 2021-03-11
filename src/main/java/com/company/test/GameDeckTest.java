package com.company.test;


import com.company.Card;
import com.company.CardsFetcher;
import com.company.GameDeck;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;


public class GameDeckTest {
    CardsFetcher cardsFetcher = new CardsFetcher();
    GameDeck gameDeck = new GameDeck( cardsFetcher);

    @Test
    public void deckConstructorTest(){
        System.out.println("=== deckConstructorTest ===");
        Assertions.assertNotNull(gameDeck.getCardsFetcher());
    }

    @Test
    public void deckConstructorExceptionTest(){
        System.out.println("=== deckConstructorExceptionTest ===");
        CardsFetcher cardsFetcher = null;

        var exception = Assertions.assertThrows(
                NullPointerException.class,
                () -> gameDeck = new GameDeck(cardsFetcher));
        Assertions.assertEquals("Cards fetcher should not be null", exception.getMessage());
    }

    @Test
    public void initializeDeckTest(){
        System.out.println("=== initializeDeckTest ===");
        Assertions.assertTrue(gameDeck.initializeDeck());
    }

    @Test
    public void getDeckTest(){
        System.out.println("=== getDeckTest ===");
        Assertions.assertNotNull(gameDeck.getDeck());
    }

    @Test
    public void testDrawCard(){
        System.out.println("=== testDrawCard ===");
        Assertions.assertNotNull(gameDeck.drawCard());
    }

    @Test
    public void testInsertCard(){
        System.out.println("=== testInsertCard ===");
        Card card = new Card("harts","1");
        Assertions.assertTrue(gameDeck.insertCard(card));
    }

    @Test
    public void testSplitDeck(){
        System.out.println("=== testSplitDeck ===");
        ArrayList<ArrayList<Card>> splitedDeck = gameDeck.splitDeck();
        ArrayList<Card> firstHand = splitedDeck.get(0);
        ArrayList<Card> secondHand = splitedDeck.get(1);

        Assertions.assertEquals(splitedDeck.size(), 2);
        Assertions.assertEquals(firstHand.size(), 26);
        Assertions.assertEquals(secondHand.size(), 26);
    }

    @Test
    public void testSetCards(){
        ArrayList<Card> cards = new ArrayList<>();
        var exception = Assertions.assertThrows(
                IllegalStateException.class,
                () -> gameDeck.setCards(cards)
        );

        Assertions.assertEquals("cards.size() must be 52", exception.getMessage());
    }
}