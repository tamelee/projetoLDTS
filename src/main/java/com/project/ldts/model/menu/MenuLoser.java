package com.project.ldts.model.menu;

import com.project.ldts.model.game.arena.Arena;

import java.util.Arrays;
import java.util.List;

public class MenuLoser {
    private final Arena arena;
    private final List<String> entries;
    private int currentEntry = 0;

    public MenuLoser(Arena arena) {
        this.entries = Arrays.asList("Restart", "Back To Menu", "Exit");
        this.arena = arena;
    }

    public Arena getArena() { return this.arena; }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedMenu() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
