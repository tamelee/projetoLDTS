package com.project.ldts.model.menu;

import com.project.ldts.model.game.scores.ScoreReader;

import java.util.Arrays;
import java.util.List;

public class MenuInfo {
    private final List<String> entry;
    private ScoreReader scores;
    private  String arena;

    public MenuInfo() {
        this.entry = Arrays.asList("Return");
    }

    public MenuInfo(String arena, ScoreReader scores) {
        this.entry = Arrays.asList("Return");
        this.scores = scores;
        this.arena = arena;
    }

    public ScoreReader getScores() {return scores;}

    public String getArena() {return arena;}

    public String getEntry(int i) {
        return entry.get(i);
    }

    public boolean isSelected(int i) {
        int currentEntry = 0;
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entry.size();
    }
}
