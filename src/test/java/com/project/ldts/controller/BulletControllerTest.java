package com.project.ldts.controller;

import com.project.ldts.Application;
import com.project.ldts.controller.game.BulletController;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.Bullet;
import com.project.ldts.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BulletControllerTest {
    private BulletController controller;
    private Arena arena;
    private Application game;

    @BeforeEach
    public void setUp(){
        arena = new Arena(30, 15);

        arena.setWalls(Arrays.asList());
        arena.setEnemies(Arrays.asList());
        arena.setPlayer(new Player(10, 10));

        controller = new BulletController(arena);
        game = Mockito.mock(Application.class);
    }

    @Test
    public void moveBullets(){
        Bullet bullet = new Bullet(10, 12, 'r');
        arena.setBullets(Arrays.asList(bullet));

        controller.step(game, GUI.ACTION.NONE, 500);
        assertNotEquals(new Position(10,12), bullet.getPosition());
    }
}
