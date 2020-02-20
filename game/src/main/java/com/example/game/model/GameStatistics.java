package com.example.game.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.concurrent.TimeUnit;

@Component
@SessionScope
public class GameStatistics {
    private int wins;
    private int loses;
    private int total;
    private int totalWinMoves;
    private double avgWinMoves;
    private long totalWinTime;
    private double avgWinTime;

    public GameStatistics() {
    }

    //region getters and setters
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getAvgWinMoves() {
        return totalWinMoves / (double) wins;
    }

    public double getAvgWinTime() {
        return totalWinTime / (double) wins;
    }

    public void setAvgWinTime(double avgWinTime) {
        this.avgWinTime = avgWinTime;
    }

    public void updateWinStatistics(int tries, long duration) {
        total++;
        wins++;
        totalWinTime += TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
        totalWinMoves += tries;
    }

    public void updateLoseStatistics() {
        loses++;
        total++;
    }

    //endregion
}
