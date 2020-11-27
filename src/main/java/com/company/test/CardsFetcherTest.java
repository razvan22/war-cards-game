package company.test;

import java.io.FileNotFoundException;
import company.CardsFetcher;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;



public class CardsFetcherTest {

    CardsFetcher cardsFetcher = new CardsFetcher();
    // TODO: 2020-11-27 Could not run this one.....


//    @Test
//    public void testReadCardsInvalidFilePathEx(){
//        System.out.println("=== testReadCardsInvalidFilePath ===");
//        CardsFetcher fetcher = new CardsFetcher();
//
//        var exception =  Assertions.assertThrows(
//                  FileNotFoundException.class,
//                ()-> fetcher.readCardsFromJsonFile("ad"));
//    }

    @Test
    public void testReadCardsFromJsonNullFilePath(){
        System.out.println("=== testReadCardsFromJsonNullFilePath ===");

        var exception =  Assertions.assertThrows(
                NullPointerException.class,
                ()-> cardsFetcher.readCardsFromJsonFile(null));
        Assertions.assertEquals("File path should not be null",exception.getMessage());
    }


    @Test
    public void testReadCardsFromJsonFile(){
        System.out.println("=== testReadCardsFromJsonFile ===");

        Assertions.assertTrue(cardsFetcher.readCardsFromJsonFile());
    }

    @Test
    public void testGetCards(){
        System.out.println("=== testGetCards ===");
        cardsFetcher.readCardsFromJsonFile();

        Assertions.assertNotNull(cardsFetcher.getCards());
        Assertions.assertTrue(cardsFetcher.getCards().size() == 52,
                ()-> "The size of cadsList should be 52");
    }

    @Test
    public void testSetCardNull(){
        System.out.println("=== testSetCardNull ===");
        cardsFetcher.readCardsFromJsonFile();


        var exception = Assertions.assertThrows(
                NullPointerException.class,
                () -> cardsFetcher.setCard(null));
        Assertions.assertEquals("Card should not be Null", exception.getMessage());
    }

}
