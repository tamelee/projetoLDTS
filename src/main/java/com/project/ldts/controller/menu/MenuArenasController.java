package com.project.ldts.controller.menu;

import com.project.ldts.Application;
import com.project.ldts.controller.Controller;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.game.arena.ArenaLoader;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.model.menu.MenuArenas;
import com.project.ldts.states.GameState;
import com.project.ldts.states.menu.MainMenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MenuArenasController extends Controller<MenuArenas> {
    public MenuArenasController(MenuArenas menu){
        super(menu);
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch(action) {
            case UP -> getModel().previousYEntry();
            case DOWN -> getModel().nextYEntry();
            case RIGHT -> getModel().nextXEntry();
            case LEFT -> getModel().previousXEntry();
            case SELECT -> {
                if(getModel().isSelectedBack()){
                    game.setState(new MainMenuState(new MainMenu()));
                    if(game.isSound())
                        new Sound("select").playSound();
                } else{
                    if(getModel().isSelectedDarkPrison()){
                        game.setState(new GameState(new ArenaLoader("DarkPrison").createArena()));
                        game.setArena("DarkPrison");
                    }
                    if(getModel().isSelectedMidnight()){
                        game.setState(new GameState(new ArenaLoader("Midnight").createArena()));
                        game.setArena("Midnight");
                    }
                    if(getModel().isSelectedGraveyard()){
                        game.setState(new GameState(new ArenaLoader("Graveyard").createArena()));
                        game.setArena("Graveyard");
                    }
                    if(getModel().isSelectedPeach()){
                        game.setState(new GameState(new ArenaLoader("Peach").createArena()));
                        game.setArena("Peach");
                    }
                    if(getModel().isSelectedMokey()){
                        game.setState(new GameState(new ArenaLoader("Mokey").createArena()));
                        game.setArena("Mokey");
                    }
                    if(game.isSound())
                        new Sound("gamestart").playSound();
                }

            }
            default -> { // fall out;
            }
        }
    }
}
