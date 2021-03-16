
package com.company;




import com.company.utility.GameInput;
import com.company.utility.GameOptions;
import com.company.utility.GameUtilities;

import java.util.ArrayList;

public class Game {
    private String winner;
    private boolean playing;
    private GameDeck gameDeck;
    private int playersTurn = 1;
    private PlayerDeck firstPlayerDeck, secondPlayerDeck;
    private Player currentPlayingPlayer, player1, player2;

    public Player getCurrentPlayingPlayer() {
        return currentPlayingPlayer;
    }

    public void setCurrentPlayingPlayer(Player currentPlayingPlayer) {
        this.currentPlayingPlayer = currentPlayingPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer2() {
        return player2;
    }

    public GameDeck getGameDeck() {
        return gameDeck;
    }

    public void setGameDeck(GameDeck gameDeck) {
        this.gameDeck = gameDeck;
    }

    public Game(){
        if (initializeGameDeck()){
            initializePlayersDecks();
        }
    }

    public void runGame(){
        if (GameOptions.startStopGame()){
            playing = addPlayers();
            while (playing){
                startPlaying();
            }
        } else {
            System.out.println("\nExiting ....\n");
        }

    }

    public void startPlaying(){
        boolean isWar;
           isWar = playHand();
           if (isWar){
               isWar = playHand();
           }
    }

    public boolean playHand(){

        int numberOfPlayedCards = 0;
        int firstPlayerDrawnCardValue = 0;
        int secondPlayerDrawnCardValue = 0;

        while (playing){
            playing = isGameOver();
            if (!playing){
                System.out.printf("\nGame Over %s is the winner! \n", getWinnersName());
            }

            switchCurrentPlayingPlayer();
            GameOptions.displayCurrentPlayer(currentPlayingPlayer);
            int selectedOption = GameInput.intInput("\n\n\n\n\n1. Draw a card.\n2. Quit Game.\n");

            if (selectedOption == 1){
                Card drawnCard = currentPlayingPlayer.drawCard();
                gameDeck.insertCard(drawnCard);
                numberOfPlayedCards++;
                System.out.printf("\n%s has %s of %s \n",currentPlayingPlayer.getName(), drawnCard.getValue(), drawnCard.getSuit());

                if (currentPlayingPlayer.equals(player1)){
                    firstPlayerDrawnCardValue =  Integer.parseInt(drawnCard.getValue());
                }

                if(currentPlayingPlayer.equals(player2)){
                    secondPlayerDrawnCardValue = Integer.parseInt(drawnCard.getValue());
                }

                if (numberOfPlayedCards == 2){

                    if (firstPlayerDrawnCardValue == secondPlayerDrawnCardValue) {
                        System.out.println("\n***************WAR IS ON******************** \n");
                        return false;
                    }

                    if (firstPlayerDrawnCardValue > secondPlayerDrawnCardValue){
                        System.out.printf("\n***** => %s wins!\n",player1.getName());
                        gameDeck.getDeck().stream().forEach(card -> player1.addCardToDeck(card));
                        gameDeck.getDeck().clear();
                    }

                    if ( secondPlayerDrawnCardValue > firstPlayerDrawnCardValue){
                        System.out.printf("\n***** => %s wins!\n",player2.getName());
                        gameDeck.getDeck().stream().forEach(card -> player2.addCardToDeck(card));
                        gameDeck.getDeck().clear();
                    }
                    numberOfPlayedCards = 0;
                    return false;
                }


            }

            if (selectedOption == 2){
                System.out.printf("\n%s is quitting the game...\n", currentPlayingPlayer.getName());
                playing = false;
            }

        }
        return false;
    }
    
    public void switchCurrentPlayingPlayer(){
        currentPlayingPlayer = (playersTurn == 1) ? player1 : player2;
        playersTurn = (playersTurn == 1) ? 2: 1;
    }

    public boolean isGameOver(){
        if (player1.getPlayerDeck().numberOfCardsInDeck() == 0 || player2.getPlayerDeck().numberOfCardsInDeck() == 0){
            return false;
        }
        else return true;
    }

    public String getWinnersName(){
        if (player1.getPlayerDeck().numberOfCardsInDeck() != 0){
            return player1.getName();
        }
        else
            return player2.getName();

    }

    private boolean addPlayers(){
        boolean success = false;
        String firstPlayerName = GameInput.stringInput("\nWrite first player's name : ");
        player1 = addPlayer(firstPlayerDeck,firstPlayerName );

        String secondPlayerName = GameInput.stringInput("\nWrite second player's name : ");
        player2 = addPlayer(secondPlayerDeck, secondPlayerName);

        if ((player2.getName() != null) && (player2.getName() != null)){
            success = true;
        }

        return success;
    }

    public Player addPlayer(PlayerDeck deck, String name){
        return new Player(name, deck);
    }

    public boolean initializePlayersDecks(){
        boolean success = false;
        ArrayList<ArrayList<Card>> gameDecks = gameDeck.splitDeck();
        firstPlayerDeck = new PlayerDeck(gameDecks.get(0));
        secondPlayerDeck = new PlayerDeck(gameDecks.get(1));

        if ((firstPlayerDeck.numberOfCardsInDeck() == 26)
                && (secondPlayerDeck.numberOfCardsInDeck() == 26)) success = true;
        return success;
    }

    public boolean initializeGameDeck(){
        gameDeck = new GameDeck(new CardsFetcher());
        return gameDeck.initializeDeck();
    }

}