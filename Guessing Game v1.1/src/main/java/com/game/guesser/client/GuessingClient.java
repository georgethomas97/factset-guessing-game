package com.game.guesser.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.guesser.service.GuessingServiceImpl;

@Component
public class GuessingClient extends Thread {

	private int actualValue = 0;
	private int count = 0;

	@Autowired
	private GuessingServiceImpl guessService;

	// This function takes input and sends it to be processed and checks whether game should be terminated.
	public String startGame(int guessValue) {
		String responseMessage = "";
		responseMessage = guessService.processGuess(actualValue, guessValue, count);
		count++;
		if (count > 2 || guessService.isTerminateFlag()) {
			Thread killThread = new Thread() {
				public void run() {
					terminate();
				}
			};
			killThread.start();
			responseMessage += "<br/><b>The game has terminated.</b>";
		}
		return responseMessage;
	}

	// used to generate the random number
	public void generateNumber() {
		actualValue = (int) (1 + Math.ceil(9 * Math.random()));
	}

	//used to terminate the application once game is over
	private void terminate() {
		try {
			Thread.sleep(1000);
			System.exit(0);
		} catch (InterruptedException e) {
			System.exit(0);
		}
	}

}
