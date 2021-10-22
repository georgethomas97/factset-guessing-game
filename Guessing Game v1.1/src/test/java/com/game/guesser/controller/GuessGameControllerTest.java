package com.game.guesser.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import com.game.guesser.client.GuessingClient;


@ExtendWith(MockitoExtension.class)
public class GuessGameControllerTest {
	
	@InjectMocks
	GuessGameController guessController;
	
	@Mock
	GuessingClient guessClient;
	
	@Test
	public void indexTest() {
		Mockito.doNothing().when(guessClient).generateNumber();
		ModelAndView view = guessController.index();
		assertEquals("index", view.getViewName());
	}
	@Test
	public void processGuessTest() {
		Mockito.when(guessClient.startGame(Mockito.anyInt())).thenReturn("Success");
		ModelAndView view = guessController.processGuess(2);
		assertEquals("Success", view.getModel().get("responseMessage"));
	}
}
