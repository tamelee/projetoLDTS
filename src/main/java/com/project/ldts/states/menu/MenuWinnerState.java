package com.project.ldts.states.menu;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.menu.MenuWinnerController;
import com.project.ldts.model.menu.MenuWinner;
import com.project.ldts.states.State;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuWinnerViewer;

public class MenuWinnerState extends State<MenuWinner> {

    public MenuWinnerState(MenuWinner model){
        super(model);
    }

    @Override
    public Viewer<MenuWinner> getViewer() {
        return new MenuWinnerViewer(getModel());
    }

    @Override
    public Controller<MenuWinner> getController() {
        return new MenuWinnerController(getModel());
    }
}
