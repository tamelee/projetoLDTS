package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.viewer.Viewer;

import java.util.*;

public class MenuScoreViewer extends Viewer<MenuInfo> {

    public MenuScoreViewer(MenuInfo menu){
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawScoreMenu(getModel().getArena(), getModel().getScores().sort(getModel().getScores().getScores()));

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(45, 25 + (i+i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#E28C12" : "#B8E4F9");
    }
}
