package com.project.ldts.viewer.game;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.elements.Water;

public class WaterViewer implements ElementViewer<Water>{
    @Override
    public void draw(Water water, GUI gui) {
        gui.drawWater(water.getPosition());
    }
}
