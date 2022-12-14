package com.project.ldts.model.game.elements;


public class SafeHouse extends Element {
    private boolean active;

    public SafeHouse(int col, int row){
        super(col,row);
        this.active = true;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
