package com.project.ldts.controller.menu;

import com.project.ldts.Application;
import com.project.ldts.controller.Controller;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.game.scores.ScoreReader;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.model.menu.MenuArenas;
import com.project.ldts.model.menu.MenuInfo;
import com.project.ldts.states.menu.MainMenuState;
import com.project.ldts.states.menu.MenuScoreState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MenuArenaScoreController extends Controller<MenuArenas> {
    public MenuArenaScoreController(MenuArenas menu){
        super(menu);
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch (action){
            case UP -> getModel().previousXEntry();
            case DOWN -> getModel().nextXEntry();
            case SELECT -> {
                if(getModel().isSelectedBack()) game.setState(new MainMenuState(new MainMenu()));
                else{
                    if(getModel().isSelectedDarkPrison()) game.setArena("DarkPrison");
                    if(getModel().isSelectedGraveyard()) game.setArena("Graveyard");
                    if(getModel().isSelectedMidnight()) game.setArena("Midnight");
                    if(getModel().isSelectedMokey()) game.setArena("Mokey");
                    if(getModel().isSelectedPeach()) game.setArena("Peach");
                    game.setState(new MenuScoreState(new MenuInfo(game.getArena(), new ScoreReader(game.getArena()))));
                }
                if(game.isSound())
                    new Sound("select").playSound();
            }
        }
    }
}
