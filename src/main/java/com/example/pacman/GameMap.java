package com.example.pacman;

public class GameMap {
    private final char[][] grid;

    public GameMap(String[] rows) {
        grid = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            grid[i] = rows[i].toCharArray();
        }
    }

    public int getRowCount() {
        return grid.length;
    }

    public int getColCount() {
        return grid[0].length;
    }

    public boolean isInside(Position position) {
        return position.getRow() >= 0
                && position.getRow() < getRowCount()
                && position.getCol() >= 0
                && position.getCol() < getColCount();
    }

    public boolean isWall(Position position) {
        return grid[position.getRow()][position.getCol()] == '#';
    }

    public boolean isWalkable(Position position) {
        return isInside(position) && !isWall(position);
    }

    public boolean hasCoin(Position position) {
        return grid[position.getRow()][position.getCol()] == '.';
    }

    public boolean hasHealthPack(Position position) {
        return grid[position.getRow()][position.getCol()] == 'H';
    }

    public void clearTile(Position position) {
        grid[position.getRow()][position.getCol()] = ' ';
    }

    public int countRemainingCoins() {
        int count = 0;
        for (char[] row : grid) {
            for (char tile : row) {
                if (tile == '.') {
                    count++;
                }
            }
        }
        return count;
    }

    public char getTile(Position position) {
        return grid[position.getRow()][position.getCol()];
    }
}