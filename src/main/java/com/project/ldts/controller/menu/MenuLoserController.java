package com.project.ldts.controller.menu;

import com.project.ldts.Application;
import com.project.ldts.controller.Controller;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.game.arena.ArenaLoader;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.model.menu.MenuLoser;
import com.project.ldts.states.GameState;
import com.project.ldts.states.menu.MainMenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MenuLoserController extends Controller<MenuLoser> {

    public MenuLoserController(MenuLoser menu){
        super(menu);
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch(action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit()) game.setState(null);
                if(getModel().isSelectedRestart()) game.setState(new GameState(new ArenaLoader(game.getArena()).createArena()));
                if(getModel().isSelectedMenu()) game.setState(new MainMenuState(new MainMenu()));
                if(game.isSound())
                    new Sound("select").playSound();
            }
            default -> { // fall out;
            }
        }
    }
}
