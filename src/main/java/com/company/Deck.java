package company;

import company.exceptions.WrongBooleanException;

import java.util.ArrayList;
import java.util.Random;

public class Deck implements DeckUtilities {

    private ArrayList<Card> cards;
    private final CardsFetcher cardsFetcher;

    public Deck(CardsFetcher cardsFetcher){

        if (cardsFetcher == null){
            throw  new NullPointerException("Cards fetcher should not be null");
        }
        else {
            this.cardsFetcher = cardsFetcher;
        }

        try {
            boolean initializedDeck =  initializeDeck();
            if (!initializedDeck){
                throw new WrongBooleanException("initializeDeck() should return true");
            }

        } catch (WrongBooleanException e){
            System.out.println(e.getMessage());
        }

        setCards(cardsFetcher.getCards());
    }

    @Override
    public int randomIndex() {
        Random random = new Random();
        return random.ints(0, cards.size())
                .findFirst()
                .getAsInt();
    }

    @Override
    public Card drawCard() {
        boolean success = false;
        Card randomCard = null;

        while (!success){
            try {
                int randomIndex = randomIndex();
                randomCard = cards.get(randomIndex);
                cards.remove(randomCard);
                success = true;
            } catch (IndexOutOfBoundsException ignored){}
        }
        return randomCard;
    }

    @Override
    public boolean insertCard(Card card) {
        if (card != null){
            cards.add(card);
        }

        return cards.contains(card);
    }

    public boolean initializeDeck(){
        return cardsFetcher.readCardsFromJsonFile();
    };

    public boolean setCards(ArrayList<Card> cards){

        if (cards.size() == 52){
            this.cards = cards;
            return true;
        }else {
            throw new IllegalStateException("cards.size() must be 52");
        }

    }

    public ArrayList<Card> getDeck(){
        return cards;
    };

    public ArrayList<ArrayList<Card>> splitDeck(){
        ArrayList<Card> firstHalf = new ArrayList<Card>();
        ArrayList<Card> secondHalf = new ArrayList<Card>();
        ArrayList<ArrayList<Card>> splintedDeck = new ArrayList<>();

        int halfDeckSelector = 0;

        while (cards.size() != 0){

            if (halfDeckSelector == 0){
                firstHalf.add(drawCard());
            }else {
                secondHalf.add(drawCard());
            }

            halfDeckSelector =  halfDeckSelector == 0 ? 1 :  0;

        }
        splintedDeck.add(firstHalf);
        splintedDeck.add(secondHalf);
        return splintedDeck;
    }
}
