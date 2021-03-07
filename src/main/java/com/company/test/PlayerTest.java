package company.test;

import company.Card;
import company.CardsFetcher;
import company.Player;
import company.PlayerDeck;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerTest {
    CardsFetcher cardsFetcher = new CardsFetcher();
    PlayerDeck playerDeck;
    Player player;

    @Test
    public void testPlayerConstructor(){
        System.out.println("=== testPlayerConstructor ===");
        cardsFetcher.readCardsFromJsonFile();
        playerDeck = new PlayerDeck(cardsFetcher.getCards());
        player = new Player("Jo",playerDeck);

        Assertions.assertNotNull(player.getName());
        Assertions.assertNotNull(player.flipCard());
    }
    
    @Test
    public void testAddCardToDeck(){
        System.out.println("=== testAddCardToDeck ===");
        Card card = new Card("ja","8");
        cardsFetcher.readCardsFromJsonFile();
        playerDeck = new PlayerDeck(cardsFetcher.getCards());
        player = new Player("Jo",playerDeck);

        Assertions.assertTrue(player.addCardToDeck(card));
    }
}