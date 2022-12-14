package com.project.ldts.states.menu;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.menu.MenuArenaScoreController;
import com.project.ldts.model.menu.MenuArenas;
import com.project.ldts.states.State;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuArenaScoreViewer;

public class MenuArenasScoreState extends State<MenuArenas> {
    public MenuArenasScoreState(MenuArenas model){
        super(model);
    }

    @Override
    public Viewer<MenuArenas> getViewer() {
        return new MenuArenaScoreViewer(getModel());
    }

    @Override
    public Controller<MenuArenas> getController() {
        return new MenuArenaScoreController(getModel());
    }
}
