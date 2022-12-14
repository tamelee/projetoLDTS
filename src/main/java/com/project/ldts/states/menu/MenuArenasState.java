package com.project.ldts.states.menu;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.menu.MenuArenasController;
import com.project.ldts.model.menu.MenuArenas;
import com.project.ldts.states.State;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuArenasViewer;

public class MenuArenasState extends State<MenuArenas> {

    public MenuArenasState(MenuArenas model){
        super(model);
    }

    @Override
    public Viewer<MenuArenas> getViewer() {
        return new MenuArenasViewer(getModel());
    }

    @Override
    public Controller<MenuArenas> getController() {
        return new MenuArenasController(getModel());
    }
}
