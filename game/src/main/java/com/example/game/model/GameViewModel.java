package com.example.game.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
@SessionScope
public class GameViewModel {
    private int secret;
    private int tries;
    private List<Move> moves = new ArrayList<>();
    private long start;
    @Autowired
    private GameStatistics statistics;

    public GameViewModel() {
        System.err.println("=====================");
    }

    @PostConstruct
    public void init() {
        tries = 0;
        moves.clear();
        start = System.nanoTime();
        secret = ThreadLocalRandom.current()
                .nextInt(100) + 1;
        System.err.println(secret);
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void play(int guess) {
        long stop = System.nanoTime();
        tries++;
        if (secret == guess) {
            statistics.updateWinStatistics(tries, stop - start);
            init();
            moves.add(new Move(guess, "You win!"));
        } else {
            if (tries >= 7) {
                Move move = new Move(secret, "You lose!");
                init();
                moves.add(move);
                statistics.updateLoseStatistics();
            } else {
                String message = "Pick larger!";
                if (guess > secret)
                    message = "Pick smaller!";
                moves.add(new Move(guess, message));
            }
        }
    }
}
