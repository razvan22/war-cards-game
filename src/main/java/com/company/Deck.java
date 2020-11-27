package company;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;
    private final CardsFetcher cardsFetcher;

    public Deck(CardsFetcher cardsFetcher){
        if (cardsFetcher == null){
            throw  new NullPointerException("Cards fetcher should not be null");
        }
        else {
            this.cardsFetcher = cardsFetcher;
        }
    }

    public boolean initializeDeck(){
        return false;
    };

    public ArrayList<Card> getDeck(){
        return null;
    };
}
