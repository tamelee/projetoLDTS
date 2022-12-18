package com.project.ldts.model.menu;

import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.scores.ScoreReader;

import java.util.Arrays;

public class MenuWinnerScore extends Entries{
    private final Arena arena;
    private final ScoreReader scores;

    public MenuWinnerScore(Arena arena, ScoreReader scores) {
        super(Arrays.asList("SAVE", "MENU", "EXIT"));
        this.arena = arena;
        this.scores = scores;
    }

    public Arena getArena() { return this.arena; }

    public ScoreReader getScore() { return scores; }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedMenu() {
        return isSelected(1);
    }
    public boolean isSelectedSave() {
        return isSelected(0);
    }
}
