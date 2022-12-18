package com.project.ldts.model.menu;

import com.project.ldts.model.game.scores.ScoreReader;

import java.util.List;

public class MenuInfo extends Entries{
    private ScoreReader scores;
    private  String arena;

    public MenuInfo() {
        super(List.of("Return"));
    }

    public MenuInfo(String arena, ScoreReader scores) {
        super(List.of("Return"));
        this.scores = scores;
        this.arena = arena;
    }

    public ScoreReader getScores() {return scores;}

    public String getArena() {return arena;}

    @Override
    public boolean isSelected(int i) {
        int currentEntry = 0;
        return currentEntry == i;
    }
}
