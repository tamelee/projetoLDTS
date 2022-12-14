package com.project.ldts.model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public MainMenu() {
        this.entries = Arrays.asList("Start", "Scores", "Instructions", "Settings", "About", "Exit");
    }

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

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedScores() {
        return isSelected(1);
    }

    public boolean isSelectedInstructions() {
        return isSelected(2);
    }

    public boolean isSelectedSettings() {
        return isSelected(3);
    }

    public boolean isSelectedAbout() {
        return isSelected(4);
    }

    public boolean isSelectedExit() {
        return isSelected(5);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
