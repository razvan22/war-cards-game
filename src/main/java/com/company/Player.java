package company;

public class Player {

    private final String name;
    private final PlayerDeck playerDeck;

    public Player(String name, PlayerDeck playerDeck) {
        this.name = name;
        this.playerDeck = playerDeck;
    }

    public String getName() {
        return name;
    }

    public Card flipCard(){
       return playerDeck.drawCard();
    }

    public boolean addCardToDeck(Card card){
        return playerDeck.insertCard(card);
    }
}