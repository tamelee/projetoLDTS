package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuWinner;
import com.project.ldts.viewer.Viewer;

public class MenuWinnerViewer extends Viewer<MenuWinner> {

    public MenuWinnerViewer(MenuWinner menu){
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawWinnerMenu(getModel().getArena().getPlayer().getScore());

        gui.drawFirstRow(getModel().getArena().getPlayer().getHealth(), getModel().getArena().getDminutes(), ' ',
                getModel().getArena().getDseconds(), getModel().getArena().getEnemies().size());

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(22, 19 + (i+i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#F2B55A" : "#FFFFFF");
    }
}
