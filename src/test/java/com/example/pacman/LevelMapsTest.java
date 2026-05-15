package com.example.pacman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LevelMapsTest {

    @Test
    void level1ShouldHaveNoMonsters() {
        String joined = String.join("", LevelMaps.level1());
        assertFalse(joined.contains("M"));
    }

    @Test
    void level2ShouldHaveMonsters() {
        String joined = String.join("", LevelMaps.level2());
        assertTrue(joined.contains("M"));
    }

    @Test
    void level3ShouldHaveHealthPackAndMoreMonstersThanLevel2() {
        String level2 = String.join("", LevelMaps.level2());
        String level3 = String.join("", LevelMaps.level3());

        long level2Monsters = level2.chars().filter(c -> c == 'M').count();
        long level3Monsters = level3.chars().filter(c -> c == 'M').count();

        assertTrue(level3.contains("H"));
        assertTrue(level3Monsters > level2Monsters);
    }
}