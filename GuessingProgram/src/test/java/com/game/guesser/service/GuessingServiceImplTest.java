package com.game.guesser.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingServiceImplTest {

    @Test
    public void processGuessTest() {
        GuessingServiceImpl guessingService = new GuessingServiceImpl();
        assertEquals("Your first guess is: 7 (cold)\n", guessingService.processGuess(1, 7, 0));
        assertEquals("Your second guess is: 3 (warm)\n", guessingService.processGuess(1, 3, 1));
        assertEquals("Your second guess is: 2 (hot)\n", guessingService.processGuess(1, 2, 1));
        assertEquals("Your last guess is: 2 (hot)\nSorry! You were unable to guess the number.", guessingService.processGuess(1, 2, 2));
        assertEquals("Your last guess is: 7.\nRight! You have won the game.", guessingService.processGuess(7,7,2));

    }
}
