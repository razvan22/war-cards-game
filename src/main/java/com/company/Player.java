package company;

public class Player {

    private String name;
    private GameDeck gameDeck;

    public Player(String name , GameDeck gameDeck){
        this.name = name;
        this.gameDeck = gameDeck;
    }

    public String getName(){
        return null;
    }

    public GameDeck getDeck() {
        return null;
    }

    public void setDeck(GameDeck gameDeck) {
        this.gameDeck = gameDeck;
    }
}

