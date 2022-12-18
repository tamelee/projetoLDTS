package com.project.ldts.model.menu;

import java.util.Arrays;

public class MenuSettings extends Entries {

    public MenuSettings() {
        super(Arrays.asList("TURN ON Sound", "TURN OFF Sound", "LIGHT Mode", "DARK Mode", "Return"));
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
}
