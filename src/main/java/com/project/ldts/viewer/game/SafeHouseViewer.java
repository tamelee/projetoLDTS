package com.project.ldts.viewer.game;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.elements.SafeHouse;

public class SafeHouseViewer implements ElementViewer<SafeHouse> {

    @Override
    public void draw(SafeHouse element, GUI gui) {
        gui.drawSafeHouse(element.getPosition());
    }
}
