package com.project.ldts.controller;

import com.project.ldts.Application;
import com.project.ldts.controller.game.PlayerController;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    private PlayerController controller;
    private Player player;
    private Arena arena;
    private Application game;

   @BeforeEach
    public void setUp(){
       arena = new Arena(30, 15);

       player = new Player(10,10);

       arena.setPlayer(player);
       arena.setWalls(Arrays.asList());
       arena.setEnemies(Arrays.asList());
       arena.setSpecialBoxes(Arrays.asList(new SpecialBox(10,11), new SpecialBox(29,10)));
       arena.setSafeHouses(Arrays.asList(new SafeHouse(2, 4), new SafeHouse(15, 15)));

       controller = new PlayerController(arena);
       game = Mockito.mock(Application.class);
   }

   @Test
    public void moveRightEmpty(){
       controller.step(game, GUI.ACTION.RIGHT, 500);
       assertEquals(new Position(11, 10), player.getPosition());
   }

    @Test
    public void moveRightNotEmpty(){
       arena.setWalls(Arrays.asList(new Wall(11, 10)));
        controller.step(game, GUI.ACTION.RIGHT, 500);
        assertEquals(new Position(10, 10), player.getPosition());
    }

    @Test
    public void moveUpEmpty(){
        controller.step(game, GUI.ACTION.UP, 500);
        assertEquals(new Position(10, 9), player.getPosition());
    }

    @Test
    public void moveDownNotEmpty(){
        controller.step(game, GUI.ACTION.DOWN, 500);
        assertEquals(new Position(10, 10), player.getPosition());
    }

    @Test
    public void moveLeftEmpty(){
        controller.step(game, GUI.ACTION.LEFT, 500);
        assertEquals(new Position(9, 10), player.getPosition());
    }

    @Test
    public void collect(){
       assertEquals(arena.getPowerTime(), 0);
       arena.collectPower();
        assertEquals(arena.getPowerTime(), 15);
    }
}
