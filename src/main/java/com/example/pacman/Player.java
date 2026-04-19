package com.example.pacman;

public class Player {
    private Position position;
    private int lives;
    private final int maxLives;
    private int collectedCoins;

    public Player(Position position, int lives) {
        this.position = position;
        this.lives = lives;
        this.maxLives = lives;
        this.collectedCoins = 0;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getLives() {
        return lives;
    }

    public int getMaxLives() {
        return maxLives;
    }

    public int getCollectedCoins() {
        return collectedCoins;
    }

    public void collectCoin() {
        collectedCoins++;
    }

    public void loseLife() {
        if (lives > 0) {
            lives--;
        }
    }

    public void restoreLife() {
        if (lives < maxLives) {
            lives++;
        }
    }
}