package company.utility;

import java.util.Random;

public class GameUtilities {

    public static int selectRandomPlayer(){
        Random random = new Random();
        return  random.nextInt(2);
    }
}
