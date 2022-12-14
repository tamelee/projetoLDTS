package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuArenas;
import com.project.ldts.viewer.Viewer;

import java.io.IOException;

public class MenuArenaScoreViewer extends Viewer<MenuArenas> {
    public MenuArenaScoreViewer(MenuArenas menu){
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawArenaScoreMenu();

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(22, 15 + (i+i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F2B55A" : "#B8E4F9");
    }
}
