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

    @Test
    void shouldMoveMonsterAndReverseAtWall() {
        String[] map = {
                "#####",
                "#P M#",
                "#   #",
                "#####"
        };

        GameEngine engine = new GameEngine(map, 3);

        Position before = engine.getMonsters().get(0).getPosition();
        engine.moveMonsters();
        Position after = engine.getMonsters().get(0).getPosition();

        assertEquals(new Position(1, 2), after);
        assertNotEquals(before, after);
    }
}