package com.example.pacman;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Pac-Man Console Game ===");
        System.out.println("Choose a level:");
        System.out.println("1 - Level 1 (Coins only)");
        System.out.println("2 - Level 2 (Monsters)");
        System.out.println("3 - Level 3 (More monsters + health pack)");
        System.out.print("Enter level number: ");

        int levelChoice = readLevelChoice(scanner);
        String[] selectedMap = getLevelMap(levelChoice);

        GameEngine engine = new GameEngine(selectedMap, 3);

        while (!engine.isGameOver() && !engine.isLevelComplete()) {
            printGame(engine);

            System.out.println("Controls: W = up, S = down, A = left, D = right, Q = quit");
            System.out.print("Your move: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("Game ended by player.");
                return;
            }

            Direction direction = parseDirection(input);
            if (direction == null) {
                System.out.println("Invalid input. Use W, A, S, D, or Q.");
                continue;
            }

            boolean moved = engine.movePlayer(direction);
            if (!moved) {
                System.out.println("You cannot move there.");
                continue;
            }

            if (!engine.isLevelComplete() && !engine.isGameOver()) {
                engine.moveMonsters();
            }
        }

        printGame(engine);

        if (engine.isLevelComplete()) {
            System.out.println("Congratulations! You completed the level!");
        } else {
            System.out.println("Game over!");
        }
    }

    private static int readLevelChoice(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                return Integer.parseInt(input);
            }
            System.out.print("Please enter 1, 2, or 3: ");
        }
    }

    private static String[] getLevelMap(int levelChoice) {
        return switch (levelChoice) {
            case 1 -> LevelMaps.level1();
            case 2 -> LevelMaps.level2();
            case 3 -> LevelMaps.level3();
            default -> throw new IllegalArgumentException("Invalid level choice");
        };
    }

    private static Direction parseDirection(String input) {
        return switch (input) {
            case "W" -> Direction.UP;
            case "S" -> Direction.DOWN;
            case "A" -> Direction.LEFT;
            case "D" -> Direction.RIGHT;
            default -> null;
        };
    }

    private static void printGame(GameEngine engine) {
        GameMap map = engine.getGameMap();
        Position playerPosition = engine.getPlayer().getPosition();
        List<Monster> monsters = engine.getMonsters();

        System.out.println();
        System.out.println("Lives: " + engine.getPlayer().getLives()
                + " | Coins collected: " + engine.getPlayer().getCollectedCoins()
                + " | Coins remaining: " + map.countRemainingCoins());

        for (int row = 0; row < map.getRowCount(); row++) {
            for (int col = 0; col < map.getColCount(); col++) {
                Position current = new Position(row, col);

                if (playerPosition.equals(current)) {
                    System.out.print('P');
                } else if (hasMonsterAt(monsters, current)) {
                    System.out.print('M');
                } else {
                    System.out.print(map.getTile(current));
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean hasMonsterAt(List<Monster> monsters, Position position) {
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
}