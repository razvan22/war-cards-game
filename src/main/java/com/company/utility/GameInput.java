package com.company.utility;

import java.util.Scanner;

public class GameInput {
    private static Scanner input = new Scanner(System.in);

    public static String stringInput(String message){
        System.out.print(message);
        return input.next();
    }

    public static int intInput(String message){
        System.out.print(message);
        return input.nextInt();
    }

}
