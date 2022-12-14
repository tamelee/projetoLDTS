package com.project.ldts.controller;

import com.project.ldts.Application;
import com.project.ldts.controller.game.EnemyController;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyControllerTest {
    private EnemyController controller;
    private Arena arena;
    private Application game;

    @BeforeEach
    public void setUp(){
        arena = new Arena(30, 15);

        arena.setWalls(Arrays.asList());
        arena.setEnemies(Arrays.asList());
        arena.setSpecialBoxes(Arrays.asList(new SpecialBox(2,14), new SpecialBox(29,10)));
        arena.setPlayer(new Player(10, 13));
        arena.setWaters(Arrays.asList(new Water(10, 10), new Water(10, 11)));

        controller = new EnemyController(arena);
        game = Mockito.mock(Application.class);
    }

    @Test
    public void moveEnemies(){
        Enemy enemy = new Enemy(10, 10);
        arena.setEnemies(Arrays.asList(enemy));

        controller.step(game, GUI.ACTION.NONE, 1000);
        assertNotEquals(new Position(10,10), enemy.getPosition());
    }

    @Test
    public void enemiesCantMove(){
        Enemy enemy = new Enemy(10, 10);
        arena.setEnemies(Arrays.asList(enemy));

        arena.setWalls(Arrays.asList(new Wall(9,10),
                                     new Wall(11,10),
                                     new Wall(10,9),
                                     new Wall(10,11)));

        controller.step(game, GUI.ACTION.NONE, 1000);
        assertEquals(new Position(10,10), enemy.getPosition());
    }

    @Test
    public void enemiesAttack(){
        Enemy enemy = new Enemy(10, 10);

        arena.setEnemies(Arrays.asList(enemy));

        controller.enemyAttack(1000);
        assertNotEquals(0, arena.getBullets().size());
    }

    @Test
    public void playerEnemyCollision(){
        Enemy enemy = new Enemy(10, 13);
        arena.setEnemies(Arrays.asList(enemy));

        arena.playerEnemyCollision(enemy);
        assertNotEquals(arena.getPlayer().getHealth(), 5);
    }

    @Test
    public void isOnWater(){
        Enemy enemy = new Enemy(10, 10);
        arena.setEnemies(Arrays.asList(enemy));

        assertFalse(arena.isOnWater(enemy.getPosition()));
    }
}
