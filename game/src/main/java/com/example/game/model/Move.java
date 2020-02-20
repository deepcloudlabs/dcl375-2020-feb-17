package com.example.game.model;

public class Move {
    private int guess;
    private String message;

    public Move() {
    }

    public Move(int guess, String message) {
        this.guess = guess;
        this.message = message;
    }

    //region getters
    public int getGuess() {
        return guess;
    }

    public String getMessage() {
        return message;
    }
    //endregion
}
