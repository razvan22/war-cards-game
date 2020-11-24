package com.company;

import java.util.ArrayList;

public class CardsFetcher {
    private final String cardsFilePath = "resources/deck_of_cards.json";
    private ArrayList<Card> cards;

    public CardsFetcher(){

    }

    public boolean readCardsFromJsonFile(){
        return false;
    }

    public ArrayList<Card> getCards() {
        return null;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
}
