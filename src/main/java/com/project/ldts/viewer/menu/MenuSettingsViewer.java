package com.project.ldts.viewer.menu;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.menu.MenuSettings;
import com.project.ldts.viewer.Viewer;

import java.io.IOException;

public class MenuSettingsViewer extends Viewer<MenuSettings> {
    public MenuSettingsViewer(MenuSettings menu){
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawSettingsMenu();

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(20, 15 + (i+i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#2FBBEE" : "#B8E4F9");
    }
}
