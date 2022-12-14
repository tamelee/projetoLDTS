package com.project.ldts.viewer.game;

import java.util.List;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.Element;
import com.project.ldts.viewer.Viewer;

public class GameViewer extends Viewer <Arena>  {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawArenaFloor(getModel().getWidth(), getModel().getHeight(), ',');
        gui.drawFirstRow(getModel().getPlayer().getHealth(), getModel().getDminutes(), getModel().getPower(),
                getModel().getDseconds(), getModel().getEnemies().size());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getSand(), new SandViewer());
        drawElements(gui, getModel().getWaters(), new WaterViewer());
        drawElements(gui, getModel().getBullets(), new BulletViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer(getModel()));
        drawElement(gui, getModel().getPlayer(), new PlayerViewer(getModel()));
        drawElements(gui, getModel().getSafeHouses(), new SafeHouseViewer());
        drawElements(gui, getModel().getSpecialBoxes(), new SpecialBoxViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}