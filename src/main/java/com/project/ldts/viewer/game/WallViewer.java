package com.project.ldts.viewer.game;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
