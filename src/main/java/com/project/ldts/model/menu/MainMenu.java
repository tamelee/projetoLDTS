package com.project.ldts.model.menu;

import java.util.Arrays;

public class MainMenu extends Entries{
    public MainMenu() {
        super(Arrays.asList("Start", "Scores", "Instructions", "Settings", "About", "Exit"));
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
}
