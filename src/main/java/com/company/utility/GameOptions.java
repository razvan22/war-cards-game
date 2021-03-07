package company.utility;

public class GameOptions {

    public static boolean startStopGame(){
        int start = 1;
        return start == GameInput.intInput("\n 1. New Game\n 0. Exit Game\n :");
    }

}
