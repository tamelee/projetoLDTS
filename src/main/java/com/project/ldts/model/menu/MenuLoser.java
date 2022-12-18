package com.project.ldts.model.menu;

import com.project.ldts.model.game.arena.Arena;

import java.util.Arrays;

public class MenuLoser extends Entries{
    private final Arena arena;

    public MenuLoser(Arena arena) {
        super(Arrays.asList("Restart", "Back To Menu", "Exit"));
        this.arena = arena;
    }

    public Arena getArena() { return this.arena; }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedMenu() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
}
