package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuArenas;
import com.project.ldts.viewer.Viewer;

public class MenuArenasViewer extends Viewer<MenuArenas> {

    public MenuArenasViewer(MenuArenas menu){
        super(menu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawArenasMenu();

        int med = getModel().getNumberEntries() / 2;
        for(int i = 0; i < getModel().getNumberEntries(); i++){
            if(i < med)
                gui.drawText(new Position(8 + (i*15), 16),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#2FBBEE" : "#B8E4F9");
            else
                gui.drawText(new Position(8 + ((i - med)*15), 19),
                        getModel().getEntry(i),
                        getModel().isSelected(i) ? "#2FBBEE" : "#B8E4F9");
        }
    }
}
