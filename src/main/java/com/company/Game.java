package com.company;




import com.company.utility.GameInput;
import com.company.utility.GameOptions;
import com.company.utility.GameUtilities;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private PlayerDeck firstPlayerDeck;
    private PlayerDeck secondPlayerDeck;
    private GameDeck gameDeck;
    private String winner;
    private boolean playGame;

    public Game(){
        gameDeck = new GameDeck(new CardsFetcher());
        playGame = GameOptions.startStopGame();
        initializeGamePlay();
        runGame();

    }

    private void runGame(){

        while (playGame){
            playHand();
        }
    }

    private void playHand(){
        boolean playHand = true;
        int numberOfPlayedCard = 0;
        int firstPlayerDrawnCardValue = 0;
        int secondPlayerDrawnCardValue = 0;

        int playerSelector = GameUtilities.randomInt();


        while (playHand){
            Player currentPlayer = selectPlayer(playerSelector);
            GameOptions.displayCurrentPlayer(currentPlayer);
            int selectedOption = GameInput.intInput("\n\n\n\n\n1. Draw a card.\n2. Quit Game.\n");


            if (selectedOption == 1){
                Card drawnCard = currentPlayer.drawCard();
                gameDeck.insertCard(drawnCard);
                numberOfPlayedCard++;
                System.out.printf("\n%s has %s of %s \n",currentPlayer.getName(), drawnCard.getValue(), drawnCard.getSuit());

                if (playerSelector == 1){
                    firstPlayerDrawnCardValue =  Integer.parseInt(drawnCard.getValue());
                }

                if(playerSelector == 2){
                    secondPlayerDrawnCardValue = Integer.parseInt(drawnCard.getValue());
                }

                if (numberOfPlayedCard == 2){

                    if (firstPlayerDrawnCardValue == secondPlayerDrawnCardValue){
                        System.out.println("\n***************WAR IS ON******************** \n");
                        GameOptions.displayCurrentPlayer(currentPlayer);
                        drawnCard = currentPlayer.drawCard();
                        int firstCardInWar = Integer.parseInt(drawnCard.getValue());


                        playerSelector = (playerSelector == 1) ?  2 : 1;
                        currentPlayer = selectPlayer(playerSelector);
                        GameOptions.displayCurrentPlayer(currentPlayer);
                        drawnCard = currentPlayer.drawCard();
                        int secondCardInWar = Integer.parseInt(drawnCard.getValue());


                        if (firstCardInWar < secondCardInWar){
                            System.out.printf("\n***** => %s wins!\n",player1.getName());
                            gameDeck.getDeck().stream().forEach(card -> player1.addCardToDeck(card));
                            gameDeck.getDeck().clear();
                        }else {
                            System.out.printf("\n***** => %s wins!\n",player2.getName());
                            gameDeck.getDeck().stream().forEach(card -> player2.addCardToDeck(card));
                            gameDeck.getDeck().clear();
                        }


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

                    playHand = false;
                }
                playerSelector = (playerSelector == 1) ?  2 : 1;

                playGame = isGameOver();
                if (!playGame){
                    System.out.printf("\nGame Over %s is the winner! \n", getWinnersName());
                }
            }
            if (selectedOption == 2){
                System.out.println("EXIT ");
                playGame = false;
                playHand = false;
            }
        }

    }

    private boolean isGameOver(){
        if (player1.getPlayerDeck().numberOfCardsInDeck() == 0 || player2.getPlayerDeck().numberOfCardsInDeck() == 0){
            return false;
        }
        else return true;
    }

    private String getWinnersName(){
        if (player1.getPlayerDeck().numberOfCardsInDeck() != 0){
            return player1.getName();
        }
        else
            return player2.getName();

    }

    private boolean addPlayers(){
        boolean success = false;
        player1 = addPlayer(firstPlayerDeck, "\nWrite first player's name : ");
        player2 = addPlayer(secondPlayerDeck, "\nWrite second player's name : ");

        if ((player2.getName() != null) && (player2.getName() != null)){
            success = true;
        }

        return success;
    }

    private Player addPlayer(PlayerDeck deck, String message){
        String playerName = GameInput.stringInput(message);
        return new Player(playerName, deck);
    }

    private void initializeGamePlay(){

        if (!playGame){
            System.out.println("Exiting ....");
        } else {
            if (initializePlayersDecks()){
                playGame = addPlayers();
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

    private Player selectPlayer(int selector){
        if (selector == 1)return player1;
        else  return player2;
    }



}

