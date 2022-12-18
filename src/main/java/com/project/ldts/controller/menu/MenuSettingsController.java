package com.project.ldts.controller.menu;

import com.project.ldts.Application;
import com.project.ldts.controller.Controller;
import com.project.ldts.gui.DarkGUI;
import com.project.ldts.gui.GUI;
import com.project.ldts.gui.LightGUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.model.menu.MenuSettings;
import com.project.ldts.states.menu.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuSettingsController extends Controller<MenuSettings> {
    public MenuSettingsController(MenuSettings menu){
        super(menu);
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedReturn()) game.setState(new MainMenuState(new MainMenu()));
                if (getModel().isSelectedTurnOn()) game.setSound(true);
                if (getModel().isSelectedTurnOff()) game.setSound(false);
                if (getModel().isSelectedLightMode()){
                    game.getGui().close();
                    game.setGui(new LightGUI(55, 30));
                }
                if (getModel().isSelectedDarkMode()){
                    game.getGui().close();
                    game.setGui(new DarkGUI(55, 30));
                }
                if(game.isSound())
                    new Sound("select").playSound();
            }
            default -> { // fall out;
            }
        }
    }
}
