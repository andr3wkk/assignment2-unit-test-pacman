package com.example.pacman;

public class Monster {
    private Position position;
    private Direction direction;

    public Monster(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void reverseDirection() {
        switch (direction) {
            case UP -> direction = Direction.DOWN;
            case DOWN -> direction = Direction.UP;
            case LEFT -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.LEFT;
        }
    }

    public void moveTo(Position newPosition) {
        this.position = newPosition;
    }
}