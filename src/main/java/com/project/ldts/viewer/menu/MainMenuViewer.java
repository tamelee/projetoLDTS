package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.viewer.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawMainMenu();

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(20, 15 + (i+i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#2FBBEE" : "#B8E4F9");
    }
}