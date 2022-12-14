package com.project.ldts.states.menu;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.menu.MenuLoserController;
import com.project.ldts.model.menu.MenuLoser;
import com.project.ldts.states.State;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuLoserViewer;

public class MenuLoserState extends State<MenuLoser> {

    public MenuLoserState(MenuLoser model){
        super(model);
    }

    @Override
    public Viewer<MenuLoser> getViewer() {
        return new MenuLoserViewer(getModel());
    }

    @Override
    public Controller<MenuLoser> getController() {
        return new MenuLoserController(getModel());
    }
}
