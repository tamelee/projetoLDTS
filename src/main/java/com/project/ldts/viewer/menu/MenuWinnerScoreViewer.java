package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuWinnerScore;
import com.project.ldts.viewer.Viewer;

public class MenuWinnerScoreViewer extends Viewer<MenuWinnerScore> {

    public MenuWinnerScoreViewer(MenuWinnerScore menu){
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        getModel().getArena().getPlayer().setName(gui.drawWinnerScoreMenu());

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(11  + (i*15), 25),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F2B55A" : "#B8E4F9");
    }
}
