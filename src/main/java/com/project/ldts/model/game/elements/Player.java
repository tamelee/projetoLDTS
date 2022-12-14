package com.project.ldts.model.game.elements;

public class Player extends Element implements Health {
    private char direction;
    private int health;
    private int score;
    private String name;

    public Player(int col, int row){
        super(col, row);
        this.direction = ' ';
        this.health = 5;
        this.score = 0;
        this.name = "Unkown";
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void increaseHealth() {
        if(health < 5)
            health += 1;
    }

    @Override
    public void decreaseHealth() {
        health -= 1;
    }
}
