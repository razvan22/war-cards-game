package company.test;

import company.CardsFetcher;
import company.Deck;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DeckTest {
    CardsFetcher cardsFetcher = new CardsFetcher();
    Deck deck = new Deck(cardsFetcher);


    @Test
    public void deckConstructorTest(){
        System.out.println("=== deckConstructorTest ===");
        Deck deck = new Deck( cardsFetcher);

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
}