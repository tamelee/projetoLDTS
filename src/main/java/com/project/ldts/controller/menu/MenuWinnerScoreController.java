package com.project.ldts.controller.menu;

import com.project.ldts.Application;
import com.project.ldts.controller.Controller;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.game.scores.ScoreWriter;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.model.menu.MenuWinner;
import com.project.ldts.model.menu.MenuWinnerScore;
import com.project.ldts.states.menu.MainMenuState;
import com.project.ldts.states.menu.MenuWinnerState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static java.lang.System.exit;

public class MenuWinnerScoreController extends Controller<MenuWinnerScore> {
    public MenuWinnerScoreController(MenuWinnerScore menu){
        super(menu);
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        switch(action) {
            case RIGHT -> getModel().nextEntry();
            case LEFT -> getModel().previousEntry();
            case SELECT -> {
                if(getModel().isSelectedSave()) {
                    String name = getModel().getArena().getPlayer().getName();
                    int score = getModel().getArena().getPlayer().getScore();
                    getModel().getScore().setTop5(name,score);
                    new ScoreWriter(game.getArena(), getModel().getScore().getScores());
                    game.setState(new MenuWinnerState(new MenuWinner(getModel().getArena())));
                }
                if(getModel().isSelectedMenu()) game.setState(new MainMenuState(new MainMenu()));
                if (getModel().isSelectedExit()) game.setState(null);
                if(game.isSound())
                    new Sound("select").playSound();
            }
        }
    }
}
