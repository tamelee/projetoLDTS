package com.project.ldts.controller.game;

import com.project.ldts.Application;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.scores.ScoreReader;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.model.menu.MenuLoser;
import com.project.ldts.model.menu.MenuWinner;
import com.project.ldts.model.menu.MenuWinnerScore;
import com.project.ldts.states.menu.MainMenuState;
import com.project.ldts.states.menu.MenuLoserState;
import com.project.ldts.states.menu.MenuWinnerScoreState;
import com.project.ldts.states.menu.MenuWinnerState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ArenaController extends GameController {
    private final PlayerController playerController;
    private final EnemyController enemyController;
    private final BulletController bulletController;
    private long lastCount;

    public ArenaController(Arena arena) {
        super(arena);

        this.playerController = new PlayerController(arena);
        this.enemyController = new EnemyController(arena);
        this.bulletController = new BulletController(arena);

        this.lastCount = 0;
    }

    public void step(Application game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MainMenuState(new MainMenu()));
        if (getModel().getEnemies().isEmpty()) {
            playerScore();
            callWinnerMenu(game, getModel().getPlayer().getScore());
            if(game.isSound())
                new Sound("gamewinner").playSound();
        }
        if (getModel().getPlayer().getHealth() == 0 || (getModel().getSeconds() == 0 && getModel().getMinutes() ==0)){
            game.setState(new MenuLoserState(new MenuLoser(getModel())));
            if(game.isSound())
                new Sound("gameover").playSound();
        }
        playerController.step(game, action, time);
        enemyController.step(game, action, time);
        enemyController.enemyAttack(time);
        bulletController.step(game, action, time);
        timeController(time);
    }

    private void timeController(long time) {
        if (time - lastCount > 1000) {
            getModel().setSeconds(getModel().getSeconds() - 1);
            getModel().setDseconds(getModel().getSeconds());

            if(getModel().getSeconds() == -1){
                getModel().setSeconds(59);
                getModel().setMinutes(getModel().getMinutes() - 1);
                getModel().setDseconds(getModel().getSeconds());
                getModel().setDminutes(getModel().getMinutes());
            }

            if(getModel().getPowerTime() > 0)
                getModel().setPowerTime(getModel().getPowerTime()-1);
            if(getModel().getPowerTime() == 0)
                getModel().setPower(' ');

            lastCount = time;
        }
    }

    private void playerScore(){
        int score = (getModel().getMinutes() * 100) + getModel().getSeconds();
        getModel().getPlayer().setScore(score);
    }

    private void callWinnerMenu(Application game, int score) throws IOException {
        ScoreReader sr = new ScoreReader(game.getArena());
        if(sr.isTop5(score)) {
            game.setState(new MenuWinnerScoreState(new MenuWinnerScore(getModel(), sr)));
        }
        else
            game.setState(new MenuWinnerState(new MenuWinner(getModel())));

    }
}
