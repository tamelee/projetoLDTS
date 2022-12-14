package com.project.ldts.model.game.elements;

import com.project.ldts.model.Position;

public abstract class Element {
    Position position;

    public Element(int col, int row){
        position = new Position(col, row);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
