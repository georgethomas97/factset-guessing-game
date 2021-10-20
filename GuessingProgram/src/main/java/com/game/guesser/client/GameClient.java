package com.game.guesser.client;

import com.game.guesser.service.GuessingServiceImpl;

import java.util.Scanner;

public class GameClient {
    GuessingServiceImpl guessService = new GuessingServiceImpl();
    private int actualValue = 0;
    private Integer guessValue = null;

    public Integer getGuessValue() {
        return guessValue;
    }

    //This function takes input and pre-screens the value data type and range.
    public void startGame() {
        actualValue = generateNumber();
        String responseMessage = "";

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("I am thinking of a number from 1-10.");
            System.out.println("You must guess what it is in three tries");
            System.out.println("Enter your guess:");
            String guessString = sc.next();
            //checking whether the input is a number
            try {
                guessValue = Integer.parseInt(guessString);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number from 1-10.\n");
                i--;
                continue;
            }
            //checking whether number falls within range
            if (guessValue < 1 || guessValue > 10) {
                System.out.println("Please enter a whole number from 1-10.\n");
                i--;
                continue;
            }
            //calling logic to generate the response message
            responseMessage = guessService.processGuess(actualValue, guessValue, i);
            System.out.println(responseMessage);
            runExitCheck();
        }
        sc.close();
    }

    //used to generate the random number
    private int generateNumber() {
        int number = (int) (1 + (9 * Math.random()));
        return number;
    }

    //checks whether program should be terminated
    private void runExitCheck() {
        if (guessService.isTerminateFlag())
            System.exit(0);
    }

}
