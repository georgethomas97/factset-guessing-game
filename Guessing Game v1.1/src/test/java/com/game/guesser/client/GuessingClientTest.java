package com.game.guesser.client;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuessingClientTest {
	
	@Autowired
	GuessingClient guessClient;

	@Test
	public void startGameTest() {
		guessClient.generateNumber();
		String responseMessage = guessClient.startGame(2);
		assertTrue(responseMessage.contains("Your first guess is:"));
	}

}
