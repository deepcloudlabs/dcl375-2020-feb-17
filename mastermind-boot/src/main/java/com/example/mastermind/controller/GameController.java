package com.example.mastermind.controller;

import com.example.mastermind.model.Game;
import com.example.mastermind.model.GameStatus;
import com.example.mastermind.model.Move;
import com.example.mastermind.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 */
@Controller
@Scope("request")
@RequestMapping("/play")
public class GameController {
	@Autowired
	private Player player;
	@Autowired
	private Game game;

	@ModelAttribute("player")
	public Player getPlayer() {
		return player;
	}

	@ModelAttribute("game")
	public Game getGame() {
		return game;
	}

	@GetMapping
	public String play() {
		return "home";
	}

	@PostMapping
	public String play(@RequestParam("guess") String guess, Model model) {
		game.setGuess(guess);
		GameStatus gameStatus = GameStatus.PLAYING;
		String errorMessage = validateGuess(guess);
		if (errorMessage != null) {
			model.addAttribute("errorMessage", errorMessage);
		} else {
			gameStatus = game.play();
		}
		String next = "home";

		switch (gameStatus) {
			case PLAYING:
				next = "home";
				break;
			case GAME_OVER:
				next = "gameover";
				break;
			case WIN:
				next = "win";
				break;
		}
		return next;
	}

	private String validateGuess(String guess) {
		if (guess == null || guess.length() == 0)
			return "You must enter your guess!";
		if (!guess.matches("\\d{" + game.getLevel() + "}"))
			return "You must enter " + game.getLevel() + "-digit integer!";
		if (hasRepeatedDigits(guess))
			return guess + " has repeated digits!";
		for (Move move : game.getHistory())
			if (move.getGuess().equals(guess))
				return "You have already entered " + guess + "!";
		return null;
	}

	private boolean hasRepeatedDigits(String guess) {
		Set<Character> digits = new HashSet<>();
		for (int i = 0; i < guess.length(); ++i)
			digits.add(guess.charAt(i));
		return guess.length() != digits.size();
	}
}
