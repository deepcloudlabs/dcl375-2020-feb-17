package com.example.game.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

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

    public int getTotalWinMoves() {
        return totalWinMoves;
    }

    public void setTotalWinMoves(int totalWinMoves) {
        this.totalWinMoves = totalWinMoves;
    }

    public double getAvgWinMoves() {
        return avgWinMoves;
    }

    public void setAvgWinMoves(double avgWinMoves) {
        this.avgWinMoves = avgWinMoves;
    }

    public long getTotalWinTime() {
        return totalWinTime;
    }

    public void setTotalWinTime(long totalWinTime) {
        this.totalWinTime = totalWinTime;
    }

    public double getAvgWinTime() {
        return avgWinTime;
    }

    public void setAvgWinTime(double avgWinTime) {
        this.avgWinTime = avgWinTime;
    }

    //endregion
}
