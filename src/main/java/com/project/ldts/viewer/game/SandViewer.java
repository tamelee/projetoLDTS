package com.project.ldts.viewer.game;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.elements.Sand;

public class SandViewer implements ElementViewer<Sand> {
    @Override
    public void draw(Sand sand, GUI gui) {
        gui.drawSand(sand.getPosition());
    }
}
