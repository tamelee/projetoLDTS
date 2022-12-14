package com.project.ldts.states.menu;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.menu.MenuInfoController;
import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.states.State;

public abstract class MenuInfoState extends State<MenuInfo> {

    public MenuInfoState(MenuInfo model) {
        super(model);
    }

    @Override
    public Controller<MenuInfo> getController(){ return new MenuInfoController(getModel());}
}
