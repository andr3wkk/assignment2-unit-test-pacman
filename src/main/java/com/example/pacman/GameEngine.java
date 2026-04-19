package com.example.pacman;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private final GameMap gameMap;
    private final Player player;
    private final List<Monster> monsters;

    public GameEngine(String[] mapRows, int startingLives) {
        this.gameMap = new GameMap(mapRows);
        this.monsters = new ArrayList<>();

        Position playerStart = null;

        for (int r = 0; r < mapRows.length; r++) {
            for (int c = 0; c < mapRows[r].length(); c++) {
                char tile = mapRows[r].charAt(c);
                Position pos = new Position(r, c);

                if (tile == 'P') {
                    playerStart = pos;
                    gameMap.clearTile(pos);
                } else if (tile == 'M') {
                    monsters.add(new Monster(pos, Direction.RIGHT));
                    gameMap.clearTile(pos);
                }
            }
        }

        if (playerStart == null) {
            throw new IllegalArgumentException("Map must contain a player start 'P'");
        }

        this.player = new Player(playerStart, startingLives);
    }

    public Player getPlayer() {
        return player;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public boolean movePlayer(Direction direction) {
        Position next = player.getPosition().move(direction);

        if (!gameMap.isWalkable(next)) {
            return false;
        }

        player.setPosition(next);

        if (gameMap.hasCoin(next)) {
            player.collectCoin();
            gameMap.clearTile(next);
        }

        if (gameMap.hasHealthPack(next)) {
            player.restoreLife();
            gameMap.clearTile(next);
        }

        checkMonsterCollision();
        return true;
    }

    public void moveMonsters() {
        for (Monster monster : monsters) {
            Position next = monster.getPosition().move(monster.getDirection());

            if (!gameMap.isWalkable(next)) {
                monster.reverseDirection();
                next = monster.getPosition().move(monster.getDirection());
            }

            if (gameMap.isWalkable(next)) {
                monster.moveTo(next);
            }
        }

        checkMonsterCollision();
    }

    public void checkMonsterCollision() {
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(player.getPosition())) {
                player.loseLife();
            }
        }
    }

    public boolean isLevelComplete() {
        return gameMap.countRemainingCoins() == 0 && !isGameOver();
    }

    public boolean isGameOver() {
        return player.getLives() <= 0;
    }
}