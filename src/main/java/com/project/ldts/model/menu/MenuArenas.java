package com.project.ldts.model.menu;

import java.util.Arrays;
import java.util.List;

public class MenuArenas {
    private final List<String> entries;
    private int currentEntry = 0;

    public MenuArenas() {
        this.entries = Arrays.asList("MOKEY", "MIDNIGHT", "GRAVEYARD", "DARK PRISON", "PEACH", "back");
    }

    public void nextXEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousXEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public void nextYEntry() {
        currentEntry = currentEntry + 3;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = currentEntry - 3;
    }

    public void previousYEntry() {
        currentEntry = currentEntry - 3;
        if (currentEntry < 0)
            currentEntry = currentEntry + 3;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }


    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedMokey() {
        return isSelected(0);
    }
    public boolean isSelectedMidnight() {
        return isSelected(1);
    }
    public boolean isSelectedGraveyard() {
        return isSelected(2);
    }
    public boolean isSelectedDarkPrison() {
        return isSelected(3);
    }
    public boolean isSelectedPeach() {
        return isSelected(4);
    }
    public boolean isSelectedBack() {
        return isSelected(5);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
