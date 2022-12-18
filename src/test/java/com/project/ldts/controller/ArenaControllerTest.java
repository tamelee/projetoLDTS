package com.project.ldts.controller;

import com.project.ldts.Application;
import com.project.ldts.controller.game.ArenaController;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.Enemy;
import com.project.ldts.model.game.elements.Player;
import com.project.ldts.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;

public class ArenaControllerTest {
    private Application game;
    private Arena model;
    private ArenaController controller;

    @BeforeEach
    public void setUp(){
        game = Mockito.mock(Application.class);
        model = Mockito.mock(Arena.class);
        Mockito.when(model.getPlayer()).thenReturn(new Player(10, 10));
        Mockito.when(model.getEnemies()).thenReturn(Arrays.asList(new Enemy(5, 6), new Enemy(25, 13)));
        Mockito.when(model.getWalls()).thenReturn(Arrays.asList(new Wall(1,1), new Wall(30,15)));
        controller = new ArenaController(model);
    }

    @Test
    public void gameController() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        controller.step(game, GUI.ACTION.DOWN, 1000);
        Mockito.verify(model, Mockito.times(1)).isPlayerAlive();

        controller.step(game, GUI.ACTION.UP, 1000);
        Mockito.verify(model, Mockito.atLeastOnce()).getPlayer();
        Mockito.verify(model, Mockito.atLeastOnce()).getEnemies();

        controller.step(game, GUI.ACTION.COLLECT, 1000);
        Mockito.verify(model, Mockito.times(1)).collectPower();
    }

    @Test
    public void playerAttackk() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        controller.step(game, GUI.ACTION.SHOT, 1000);
        Mockito.verify(model, Mockito.times(1)).firePlayerShots();
        Mockito.verify(model, Mockito.times(1)).getBullets();
    }
}
