package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuLoser;
import com.project.ldts.viewer.Viewer;

public class MenuLoserViewer extends Viewer<MenuLoser> {

    public MenuLoserViewer(MenuLoser menu){
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawLoserMenu();

        gui.drawFirstRow(getModel().getArena());

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(22, 19 + (i+i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F04C4C" : "#FFFFFF");
    }
}
