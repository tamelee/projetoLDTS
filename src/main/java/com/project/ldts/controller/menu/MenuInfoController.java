package com.project.ldts.controller.menu;

import com.project.ldts.Application;
import com.project.ldts.controller.Controller;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.states.menu.MainMenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MenuInfoController extends Controller<MenuInfo> {

    public MenuInfoController(MenuInfo menu){
        super(menu);
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if(action == GUI.ACTION.SELECT) {
            game.setState(new MainMenuState(new MainMenu()));
            if(game.isSound())
                new Sound("select").playSound();
        }
    }
}
