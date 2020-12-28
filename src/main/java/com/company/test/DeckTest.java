package company.test;

import company.Card;
import company.CardsFetcher;
import company.Deck;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DeckTest {
    CardsFetcher cardsFetcher = new CardsFetcher();
    Deck deck = new Deck( cardsFetcher);


    @Test
    public void deckConstructorTest(){
        System.out.println("=== deckConstructorTest ===");
        Assertions.assertNotNull(deck.getCardsFetcher());
    }

    @Test
    public void initializeDeckTest(){
        System.out.println("=== initializeDeckTest ===");
        Assertions.assertTrue(deck.initializeDeck());
    }

    @Test
    public void getDeckTest(){
        System.out.println("=== getDeckTest ===");
        Assertions.assertNotNull(deck.getDeck());
    }

    @Test
    public void testDrawCard(){
        System.out.println("=== testDrawCard ===");
        Assertions.assertNotNull(deck.drawCard());
    }

    @Test
    public void testInsterCard(){
        System.out.println("=== testInsertCard ===");
        Card card = new Card("harts","1");
        Assertions.assertTrue(deck.insertCard(card));
    }

    @Test
    public void testSplitDeck(){
        System.out.println("=== testSplitDeck ===");
        Assertions.assertTrue(deck.splitDeck().size() == 2);
        System.out.println(deck.splitDeck().size());

    }


}