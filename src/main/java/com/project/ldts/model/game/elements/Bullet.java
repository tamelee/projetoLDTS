package com.project.ldts.model.game.elements;

import com.project.ldts.model.Position;

public class Bullet extends Element{
    private final char direction;

    public Bullet(int col, int row, char direction){
        super(col, row);
        this.direction = direction;
    }

    public Position move(){
        return switch (direction){
            case 'r' -> new Position(position.getX() + 1, position.getY());
            case 'd' -> new Position(position.getX(), position.getY() + 1);
            case 'l' -> new Position(position.getX() - 1, position.getY());
            default -> new Position(position.getX(), position.getY() - 1);
        };
    }
}
