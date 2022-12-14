package com.project.ldts.model.game.elements;

public class Enemy extends Element implements Health{
    private int health;
    public Enemy(int col, int row){
        super(col, row);
        this.health = 3;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void increaseHealth() {
        if(health < 3)
            health += 1;
    }

    @Override
    public void decreaseHealth() {
        health -= 1;
    }
}
