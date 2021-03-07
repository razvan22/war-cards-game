package company;

import company.utility.GameInput;
import company.utility.GameOptions;
import company.utility.GameUtilities;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private PlayerDeck firstPlayerDeck;
    private PlayerDeck secondPlayerDeck;
    private GameDeck gameDeck;
    private String winner;
    private boolean gameStatus;

    public Game(){
        gameDeck = new GameDeck(new CardsFetcher());
        gameStatus = GameOptions.startStopGame();
        initializeGamePlay();
        runGame(gameStatus);

    }

    private void runGame(boolean gameStatus){
        while (gameStatus){
            switch (GameUtilities.selectRandomPlayer()){
                case 0:
                    System.out.println(player1.getName());
                    break;
                case 1:
                    System.out.println(player2.getName());
                    break;
            }
        }

    }

    private boolean addPlayers(){
        boolean success = false;
        player1 = addPlayer(firstPlayerDeck);
        player2 = addPlayer(secondPlayerDeck);

        if ((player2.getName() != null) && (player2.getName() != null)){
            success = true;
        }

        return success;
    }

    private Player addPlayer(PlayerDeck deck){
        String playerName = GameInput.stringInput("Write player name :");
        return new Player(playerName, deck);
    }

    private void initializeGamePlay(){

        if (!gameStatus){
            System.out.println("Exiting ....");
        } else {
            if (initializePlayersDecks()){
                gameStatus = addPlayers();
            }
        }
    }

    private boolean initializePlayersDecks(){
        boolean success = false;
        ArrayList<ArrayList<Card>> gameDecks = gameDeck.splitDeck();
        firstPlayerDeck = new PlayerDeck(gameDecks.get(0));
        secondPlayerDeck = new PlayerDeck(gameDecks.get(1));

        if ((firstPlayerDeck.numberOfCardsInDeck() == 26)
                && (secondPlayerDeck.numberOfCardsInDeck() == 26)) success = true;
        return success;
    }



}

class GameRunner{
    public static void main(String[] args) {
     new Game();
    }
}