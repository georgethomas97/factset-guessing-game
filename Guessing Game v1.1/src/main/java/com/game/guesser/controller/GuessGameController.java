package com.game.guesser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.game.guesser.client.GuessingClient;

@Controller
public class GuessGameController {
	
	@Autowired
	GuessingClient guessClient;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView view=new ModelAndView();
		guessClient.generateNumber();
		view.setViewName("index");
		return view;
	}
	@RequestMapping("/processGuess")
	public ModelAndView processGuess(int guessValue) {
		String responseMessage = guessClient.startGame(guessValue);
		ModelAndView view=new ModelAndView();
		view.addObject("responseMessage", responseMessage);
		view.setViewName("index");
		return view;
	}
}
