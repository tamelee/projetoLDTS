package com.project.ldts.model.menu;

import java.util.List;

public abstract class Entries {
    public final List<String> entries;
    public int currentEntry = 0;

    public Entries(List<String> entries){
        this.entries = entries;
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

    public int getNumberEntries() {
        return this.entries.size();
    }
}
