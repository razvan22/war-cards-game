package company;

import java.util.ArrayList;
import java.util.Random;

public class PlayerDeck implements DeckUtilities{

    private final ArrayList<Card> cards ;

    public PlayerDeck(ArrayList<Card> cards) {

        if (cards.size() < 26){
            throw new IllegalStateException("cards.size() should be 26");
        }
        else {
            this.cards = cards;
        }
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
        if ((card != null) & (!cards.contains(card))){
            cards.add(card);
        }
        return cards.contains(card);
    }

    @Override
    public int randomIndex() {
        Random random = new Random();
        return random.ints(0, cards.size())
                .findFirst()
                .getAsInt();
    }

    public int numberOfCardsInDeck(){
        return cards.size();
    }
}