package company;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;
    private final CardsFetcher cardsFetcher;

    public Deck(CardsFetcher cardsFetcher){
        this.cardsFetcher = cardsFetcher;
    }

    private ArrayList<Card> initializeDeck(){
        return null;
    };

    private ArrayList<Card> getDeck(){
        return null;
    };
}
