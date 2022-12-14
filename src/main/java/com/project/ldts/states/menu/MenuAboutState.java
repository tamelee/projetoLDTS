package com.project.ldts.states.menu;

import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuAboutViewer;

public class MenuAboutState extends MenuInfoState{

    public MenuAboutState(MenuInfo model) {super(model);}

    @Override
    public Viewer<MenuInfo> getViewer() {
        return new MenuAboutViewer(getModel());
    }
}
