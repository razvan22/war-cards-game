package com.company.test;

import com.company.*;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import com.company.CardsFetcher;

import java.util.ArrayList;


public class GameTest {


    @Test
    public void initializeGameDeckTest(){
        Game game =  new Game();
        System.out.println("==== initializeGameDeckTest===");
        Assertions.assertTrue(game.initializeGameDeck());

        String invalidPath = "resources/deck_of_cards_test.json";
        try {
            CardsFetcher cardsFetcher = new CardsFetcher();
            cardsFetcher.setCardsFilePath(invalidPath);
            GameDeck gameDeck = new GameDeck(cardsFetcher);
            Assertions.assertFalse(gameDeck.initializeDeck());
        } catch (IllegalStateException  e){

        }

    }

    @Test
    public void initializePlayersDecksTest(){
        System.out.println("==== initializePlayersDecksTest ===");
      try{
          Game game =  new Game();
          Assertions.assertFalse(game.initializePlayersDecks());
      }catch (IllegalStateException e) {

      }

        Game game = new Game();
        game.initializeGameDeck();
        Assertions.assertTrue(game.initializePlayersDecks());

    }

    @Test
    public void addPlayerTest(){
        System.out.println("===== addPlayerTest =====");
      try{
          Game game = new Game();

          PlayerDeck playerDeck = new PlayerDeck(new ArrayList<>());
          String name = "Joe";
          var playerName =   game.addPlayer(playerDeck,name).getName();
          Assertions.assertEquals(playerName,name);
      }catch (IllegalStateException e){

      }

    }

    @Test
    public void switchCurrentPlayingPlayerTest(){
        System.out.println("==== switchCurrentPlayingPlayerTest ====");
        try{
            Game game = new Game();
            PlayerDeck playerDeck = new PlayerDeck(new ArrayList<>());
            Player player1 = new Player("Joe",playerDeck);
            Player player2 = new Player("Mike",playerDeck);

            game.setPlayer1(player1);
            game.setPlayer2(player2);
            game.switchCurrentPlayingPlayer();
            Assertions.assertEquals(game.getCurrentPlayingPlayer(),game.getPlayer2());
            game.switchCurrentPlayingPlayer();
            Assertions.assertEquals(game.getCurrentPlayingPlayer(),game.getPlayer1());

        } catch (IllegalStateException e){

        }
    }

    @Test
    public void getWinnersNameTest(){
        System.out.println("==== getWinnersNameTest ====");
        try{
            Game game = new Game();
            PlayerDeck playerDeck = new PlayerDeck(new ArrayList<>());
            Player player1 = new Player("Joe",playerDeck);
            Player player2 = new Player("Mike",playerDeck);

            game.getPlayer1().getPlayerDeck().getDeck().clear();
            String winnerName = player2.getName();
            Assertions.assertEquals(game.getWinnersName(),winnerName);

        }catch (IllegalStateException e){

        }
    }

    @Test
    public void isGameOverTest(){
        System.out.println("==== isGameOverTest ====");
        try{
            Game game = new Game();
            PlayerDeck playerDeck = new PlayerDeck(new ArrayList<>());
            Player player1 = new Player("Joe",playerDeck);
            Player player2 = new Player("Mike",playerDeck);

            game.getPlayer1().getPlayerDeck().getDeck().clear();

            Assertions.assertFalse(game.isGameOver());

        }catch (IllegalStateException e){

        }
    }

}
