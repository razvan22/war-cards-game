package com.company.utility;

import java.util.Random;

public class GameUtilities {

    public static int randomInt(){
        Random random = new Random();
        return  random.nextInt(2) + 1;
    }
}
