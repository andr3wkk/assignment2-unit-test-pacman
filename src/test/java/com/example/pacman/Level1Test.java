package com.example.pacman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Level1Test {

    @Test
    void shouldMovePlayerIntoEmptyTile() {
        String[] map = {
                "#####",
                "#P  #",
                "# . #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        boolean moved = engine.movePlayer(Direction.RIGHT);

        assertTrue(moved);
        assertEquals(new Position(1, 2), engine.getPlayer().getPosition());
    }

    @Test
    void shouldNotMovePlayerIntoWall() {
        String[] map = {
                "#####",
                "#P  #",
                "# . #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        boolean moved = engine.movePlayer(Direction.LEFT);

        assertFalse(moved);
        assertEquals(new Position(1, 1), engine.getPlayer().getPosition());
    }

    @Test
    void shouldCollectCoinWhenSteppingOnCoin() {
        String[] map = {
                "#####",
                "#P. #",
                "#   #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        engine.movePlayer(Direction.RIGHT);

        assertEquals(1, engine.getPlayer().getCollectedCoins());
        assertEquals(0, engine.getGameMap().countRemainingCoins());
    }

    @Test
    void shouldCompleteLevelWhenLastCoinCollected() {
        String[] map = {
                "#####",
                "#P. #",
                "#   #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        assertFalse(engine.isLevelComplete());
        engine.movePlayer(Direction.RIGHT);
        assertTrue(engine.isLevelComplete());
    }
}