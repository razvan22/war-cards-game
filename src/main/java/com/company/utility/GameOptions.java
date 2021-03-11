package com.company.utility;

import com.company.Player;

public class GameOptions {

    public static boolean startStopGame(){
        int start = 1;
        return start == GameInput.intInput("\n 1. New Game\n 0. Exit Game\n :");
    }

    public static void displayCurrentPlayer(Player player){
        System.out.printf("\nIs %s's turn ! \n",player.getName());
    }

}
