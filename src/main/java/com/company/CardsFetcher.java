package company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class CardsFetcher {
    private final String cardsFilePath = "resources/deck_of_cards.json";
    private final ArrayList<Card> cards = new ArrayList<>();



    public boolean readCardsFromJsonFile(String filePath) {

        if (filePath == null){
            throw new NullPointerException("File path should not be null");
        }

        try {

            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            Arrays.stream(gson.fromJson(br, Card[].class)).forEach(this::setCard);
        } catch (FileNotFoundException e) {
            System.out.println("exception message "+e.getMessage());
            e.printStackTrace();
        }
        return cards.size() == 52;
    }

    public boolean readCardsFromJsonFile() {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(cardsFilePath));
            Arrays.stream(gson.fromJson(br, Card[].class)).forEach(this::setCard);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cards.size() == 52;
    }


    public ArrayList<Card> getCards() {
        if (cards.size() == 52){
            return cards;
        }else {
            throw new IllegalStateException("Cards list is incomplete!");
        }
    }

    public void setCard(Card card) {
        if (card == null) {
            throw new NullPointerException("Card should not be Null");
        } else {
            cards.add(card);
        }
    }

}
