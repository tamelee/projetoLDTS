package com.project.ldts.model.menu;

import java.util.Arrays;
import java.util.List;

public class MenuSettings {
    private final List<String> entries;
    private int currentEntry = 0;

    public MenuSettings() {
        this.entries = Arrays.asList("TURN ON Sound", "TURN OFF Sound", "LIGHT Mode", "DARK Mode", "Return");
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

    public boolean isSelectedTurnOn() {
        return isSelected(0);
    }

    public boolean isSelectedTurnOff() {
        return isSelected(1);
    }

    public boolean isSelectedLightMode() {
        return isSelected(2);
    }

    public boolean isSelectedDarkMode() {
        return isSelected(3);
    }

    public boolean isSelectedReturn() {
        return isSelected(4);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
