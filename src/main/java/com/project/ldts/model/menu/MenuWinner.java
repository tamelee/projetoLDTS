package com.project.ldts.model.menu;

import com.project.ldts.model.game.arena.Arena;

import java.util.Arrays;

public class MenuWinner extends Entries{
    private final Arena arena;

    public MenuWinner(Arena arena) {
        super(Arrays.asList("Play Again", "High Scores", "Back To Menu", "Exit"));
        this.arena = arena;
    }

    public Arena getArena() { return this.arena; }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedScores() {
        return isSelected(1);
    }

    public boolean isSelectedMenu() {
        return isSelected(2);
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }
}
