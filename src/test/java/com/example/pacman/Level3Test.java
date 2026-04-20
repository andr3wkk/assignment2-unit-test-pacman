package com.example.pacman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Level3Test {

    @Test
    void shouldRestoreLifeWhenHealthPackCollected() {
        String[] map = {
                "#####",
                "#PMH#",
                "# . #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        engine.movePlayer(Direction.RIGHT);
        assertEquals(2, engine.getPlayer().getLives());

        engine.movePlayer(Direction.RIGHT);
        assertEquals(3, engine.getPlayer().getLives());
    }

    @Test
    void shouldNotExceedMaxLivesAfterHealthPack() {
        String[] map = {
                "#####",
                "#PH #",
                "# . #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        engine.movePlayer(Direction.RIGHT);

        assertEquals(3, engine.getPlayer().getLives());
    }

    @Test
    void shouldConsumeHealthPackAfterUse() {
        String[] map = {
                "#####",
                "#PH #",
                "# . #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        engine.movePlayer(Direction.RIGHT);

        assertFalse(engine.getGameMap().hasHealthPack(new Position(1, 2)));
    }
}