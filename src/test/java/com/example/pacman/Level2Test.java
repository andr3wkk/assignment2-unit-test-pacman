package com.example.pacman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Level2Test {

    @Test
    void shouldLoseLifeWhenCollidingWithMonster() {
        String[] map = {
                "#####",
                "#PM #",
                "# . #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        engine.movePlayer(Direction.RIGHT);

        assertEquals(2, engine.getPlayer().getLives());
    }

    @Test
    void shouldEndGameWhenLivesReachZero() {
        String[] map = {
                "#####",
                "#PM #",
                "# . #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 1);

        engine.movePlayer(Direction.RIGHT);

        assertTrue(engine.isGameOver());
    }

    @Test
    void shouldNotCompleteLevelWhileCoinsRemain() {
        String[] map = {
                "#####",
                "#P M#",
                "# . #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        assertFalse(engine.isLevelComplete());
    }
}