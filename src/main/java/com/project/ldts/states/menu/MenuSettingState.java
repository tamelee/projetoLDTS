package com.project.ldts.states.menu;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.menu.MenuSettingsController;
import com.project.ldts.model.menu.MenuSettings;
import com.project.ldts.states.State;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.menu.MenuSettingsViewer;

public class MenuSettingState extends State<MenuSettings> {
    public MenuSettingState(MenuSettings model){
        super(model);
    }

    @Override
    public Viewer<MenuSettings> getViewer() {
        return new MenuSettingsViewer(getModel());
    }

    @Override
    public Controller<MenuSettings> getController() {
        return new MenuSettingsController(getModel());
    }
}
