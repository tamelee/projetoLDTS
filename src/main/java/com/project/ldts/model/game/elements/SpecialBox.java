package com.project.ldts.model.game.elements;

public class SpecialBox extends Element{
    private boolean used;

    public SpecialBox(int col, int row) {
        super(col, row);
        this.used = false;
    }

    public boolean isUsed(){
        return used;
    }

    public void setUsed(boolean used){
        this.used = used;
    }

    public char getRandomPower() {
        int n = (int) (Math.random() * 3);
        return switch (n) {
            case 0 -> 'i';
            case 1 -> 't';
            default -> 'p';
        };
    }
}
