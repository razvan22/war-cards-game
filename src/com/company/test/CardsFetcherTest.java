package com.company.test;

import com.company.CardsFetcher;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CardsFetcherTest {

    CardsFetcher cardsFetcher = new CardsFetcher();

    @Test
    public void testReadCardsFromJsonFile(){
        System.out.println("=== testReadCardsFromJsonFile ===");
        Assertions.assertTrue(cardsFetcher.readCardsFromJsonFile());
    }

    @Test
    public void testGetCards(){
        System.out.println("=== testGetCards ===");
        Assertions.assertNotNull(cardsFetcher.getCards());
    }

}
