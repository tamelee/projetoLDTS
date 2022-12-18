package com.project.ldts.model;

import java.util.Objects;

public class Position {
    private final int x;
    private final int y;

    public Position(int col, int row){
        x = col;
        y = row;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getLeft() { return new Position(x - 1, y); }

    public Position getRight() { return new Position(x + 1, y); }

    public Position getUp() { return new Position(x, y - 1); }

    public Position getDown() { return new Position(x, y + 1); }

    public Position getRandomNeighbour() {
        int n = (int) (Math.random() * 4);
        return switch (n) {
            case 0 -> getUp();
            case 1 -> getRight();
            case 2 -> getDown();
            default -> getLeft();
        };
    }

    public boolean checkIfNear(Position pos){
        if(getUp().equals(pos))
            return true;
        if(getDown().equals(pos))
            return true;
        if(getLeft().equals(pos))
            return true;
        return getRight().equals(pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
