package com.project.ldts.states.menu;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.menu.MenuWinnerScoreController;
import com.project.ldts.model.menu.MenuWinnerScore;
import com.project.ldts.states.State;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuWinnerScoreViewer;

public class MenuWinnerScoreState extends State<MenuWinnerScore> {
    public MenuWinnerScoreState(MenuWinnerScore model){
        super(model);
    }

    @Override
    public Viewer<MenuWinnerScore> getViewer() {
        return new MenuWinnerScoreViewer(getModel());
    }

    @Override
    public Controller<MenuWinnerScore> getController() {
        return new MenuWinnerScoreController(getModel());
    }
}
