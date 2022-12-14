package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.viewer.Viewer;

public class MenuAboutViewer extends Viewer<MenuInfo> {
    public MenuAboutViewer(MenuInfo menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawAboutMenu();

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(45, 25 + (i+i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#2FBBEE" : "#B8E4F9");
    }
}
