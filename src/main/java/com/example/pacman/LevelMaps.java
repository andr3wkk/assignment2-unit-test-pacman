package com.example.pacman;

public class LevelMaps {

    private LevelMaps() {
    }

    public static String[] level1() {
        return new String[]{
                "#######",
                "#P .  #",
                "#  .  #",
                "#   . #",
                "#######"
        };
    }

    public static String[] level2() {
        return new String[]{
                "########",
                "#P .  M#",
                "#  .   #",
                "# M  . #",
                "########"
        };
    }

    public static String[] level3() {
        return new String[]{
                "#########",
                "#P .   M#",
                "#  H .  #",
                "# M  . M#",
                "#########"
        };
    }
}