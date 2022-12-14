package com.project.ldts.states.menu;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.menu.MainMenuController;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.states.State;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    public Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    public Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
