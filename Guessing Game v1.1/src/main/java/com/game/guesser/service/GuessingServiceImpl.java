package com.game.guesser.service;

import org.springframework.stereotype.Service;

@Service
public class GuessingServiceImpl {
	
	private boolean terminateFlag = false;

    //The terminate flag is set to true if a guess is correct or the user has guessed thrice.
    public boolean isTerminateFlag() {
        return terminateFlag;
    }

    /*
    Creates the response message based on the difference between
    the guess and the actual value and the number of guesses.
    */
    public String processGuess(int actualValue, int guessValue, int count) {

        String responseMessage = "";
        String guessIndex = getIndex(count);
        int difference = Math.abs(actualValue - guessValue);
        responseMessage = "Your " + guessIndex + " guess is: " + guessValue;
        if (difference == 0) {
            responseMessage = responseMessage + ".<br/>Right! You have won the game.";
            terminateFlag = true;
        } else {
            String temperature = getTemperature(difference);
            responseMessage = responseMessage + " (" + temperature + ")";
            if (count == 2) responseMessage = responseMessage + "<br/>Sorry! You were unable to guess the number.";

        }

        return responseMessage;
    }

    //Used to calculate the index of the guess (first/second/third)
    private String getIndex(int count) {
        String index = "";
        switch (count) {
            case 0:
                index = "first";
                break;
            case 1:
                index = "second";
                break;
            case 2:
                index = "last";
                break;
            default:
        }
        return index;
    }

    //Used to calculate the temperature (closeness) of the guess (cold/warm/hot)
    private String getTemperature(int difference) {
        String temperature = "";
        if (difference >= 3) {
            temperature = "cold";
        } else {
            switch (difference) {
                case 1:
                    temperature = "hot";
                    break;
                case 2:
                    temperature = "warm";
                    break;
                default:
            }
        }
        return temperature;
    }

}