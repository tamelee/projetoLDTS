package com.project.ldts.states.menu;

import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuScoreViewer;

public class MenuScoreState extends MenuInfoState{

    public MenuScoreState(MenuInfo model){
        super(model);
    }

    @Override
    public Viewer<MenuInfo> getViewer() {
        return new MenuScoreViewer(getModel());
    }
}
