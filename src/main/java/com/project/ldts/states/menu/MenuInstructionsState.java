package com.project.ldts.states.menu;

import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuInstructionsViewer;

public class MenuInstructionsState extends MenuInfoState{
    public MenuInstructionsState(MenuInfo model){
        super(model);
    }

    @Override
    public Viewer<MenuInfo> getViewer() {
        return new MenuInstructionsViewer(getModel());
    }
}
