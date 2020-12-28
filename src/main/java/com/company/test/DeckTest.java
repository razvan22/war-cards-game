package company.test;

import company.Card;
import company.CardsFetcher;
import company.Deck;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
    public void deckConstructorExceptionTest(){
        System.out.println("=== deckConstructorExceptionTest ===");
        CardsFetcher cardsFetcher = null;

        var exception = Assertions.assertThrows(
                NullPointerException.class,
                () -> deck = new Deck(cardsFetcher));
        Assertions.assertEquals("Cards fetcher should not be null", exception.getMessage());
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
    public void testInsertCard(){
        System.out.println("=== testInsertCard ===");
        Card card = new Card("harts","1");
        Assertions.assertTrue(deck.insertCard(card));
    }

    @Test
    public void testSplitDeck(){
        System.out.println("=== testSplitDeck ===");
        ArrayList<ArrayList<Card>> splitedDeck = deck.splitDeck();
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
                () -> deck.setCards(cards)
        );

        Assertions.assertEquals("cards.size() must be 52", exception.getMessage());
    }
}