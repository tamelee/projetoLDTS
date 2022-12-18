package com.project.ldts.controller.menu;

import com.project.ldts.Application;
import com.project.ldts.controller.Controller;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.model.menu.MenuArenas;
import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.model.menu.MenuSettings;
import com.project.ldts.states.menu.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu menu) {
        super(menu);
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit()) game.setState(null);
                if(getModel().isSelectedAbout()) game.setState(new MenuAboutState(new MenuInfo()));
                if(getModel().isSelectedSettings()) game.setState(new MenuSettingState(new MenuSettings()));
                if(getModel().isSelectedInstructions()) game.setState(new MenuInstructionsState(new MenuInfo()));
                if(getModel().isSelectedScores()) game.setState(new MenuArenasScoreState(new MenuArenas()));
                if (getModel().isSelectedStart()) game.setState(new MenuArenasState(new MenuArenas()));
                if(game.isSound())
                    new Sound("select").playSound();
            }
            default -> { // fall out;
            }
        }
    }
}