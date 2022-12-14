package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.viewer.Viewer;

public class MenuInstructionsViewer extends Viewer<MenuInfo> {
    public MenuInstructionsViewer(MenuInfo menu){
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawInstructionsMenu();

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(45, 25 + (i+i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#2FBBEE" : "#B8E4F9");

    }
}
