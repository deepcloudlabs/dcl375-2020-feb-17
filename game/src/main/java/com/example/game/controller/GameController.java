
package com.example.game.controller;

import com.example.game.model.GameStatistics;
import com.example.game.model.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("play")
public class GameController {
    @Autowired
    private GameViewModel game;
    @Autowired
    private GameStatistics statistics;

    @ModelAttribute("game")
    public GameViewModel getGame() {
        return game;
    }

    @ModelAttribute("statistics")
    public GameStatistics getStatistics() {
        return statistics;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String play(int guess) {
        game.play(guess);
        return "home";
    }
}
