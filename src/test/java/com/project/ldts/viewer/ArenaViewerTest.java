package com.project.ldts.viewer;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.*;
import com.project.ldts.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ArenaViewerTest {
    private GUI gui;
    private GameViewer gameViewer;
    private Arena arena;

    @BeforeEach
    public void setUp(){
        arena = new Arena(30, 15);

        gameViewer = new GameViewer(arena);
        gui = Mockito.mock(GUI.class);

        arena.setPlayer(new Player(10, 6));
        arena.setEnemies(Arrays.asList(new Enemy(2,3), new Enemy(10,11), new Enemy(24,6)));
        arena.setWalls(Arrays.asList(new Wall(1,1), new Wall(9,5), new Wall(1,5)));
        arena.setWaters(Arrays.asList(new Water(4,4), new Water(4,5), new Water(4,6)));
        arena.setBullets(Arrays.asList(new Bullet(11,6,'r'), new Bullet(12,6,'r')));
        arena.setSafeHouses(Arrays.asList(new SafeHouse(10, 10), new SafeHouse(15, 15)));
        arena.setSand(Arrays.asList(new Sand(10, 8), new Sand(27,14), new Sand(28,14)));
        arena.setSpecialBoxes(Arrays.asList(new SpecialBox(2,14), new SpecialBox(29,10)));
    }

    @Test
    public void drawPlayer() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(10,6));
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));

        arena.getPlayer().setPosition(new Position(10, 8));
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawOnSand(new Position(10, 8), 'X', "#DE5912");

        arena.getPlayer().setPosition(new Position(4, 4));
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawOnWater(new Position(4, 4), 'X');
    }

    @Test
    public void drawEnemies() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(2,3));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(10,11));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(24,6));
        Mockito.verify(gui, Mockito.times(3)).drawEnemy(Mockito.any(Position.class));

        arena.getEnemies().get(0).setPosition(new Position(10, 8));
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawOnSand(new Position(10, 8), '@', "#620D9C");

        arena.getEnemies().get(0).setPosition(new Position(4, 4));
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawOnWater(new Position(4, 4), '@');
    }

    @Test
    public void drawWall() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1,1));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(9,5));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1,5));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    public void drawWater() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWater(new Position(4,4));
        Mockito.verify(gui, Mockito.times(1)).drawWater(new Position(4,5));
        Mockito.verify(gui, Mockito.times(1)).drawWater(new Position(4,6));
        Mockito.verify(gui, Mockito.times(3)).drawWater(Mockito.any(Position.class));
    }

    @Test
    public void drawSand() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawSand(new Position(10,8));
        Mockito.verify(gui, Mockito.times(1)).drawSand(new Position(27,14));
        Mockito.verify(gui, Mockito.times(1)).drawSand(new Position(28,14));
        Mockito.verify(gui, Mockito.times(3)).drawSand(Mockito.any(Position.class));
    }

    @Test
    public void drawSafeHouse() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawSafeHouse(new Position(10,10));
        Mockito.verify(gui, Mockito.times(1)).drawSafeHouse(new Position(15,15));
        Mockito.verify(gui, Mockito.times(2)).drawSafeHouse(Mockito.any(Position.class));
    }

    @Test
    public void drawBullets() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBullet(new Position(11,6));
        Mockito.verify(gui, Mockito.times(1)).drawBullet(new Position(12,6));
        Mockito.verify(gui, Mockito.times(2)).drawBullet(Mockito.any(Position.class));
    }

    @Test
    public void drawSpecialBoxes() throws IOException {
        gameViewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawSpecialBox(new Position(2,14));
        Mockito.verify(gui, Mockito.times(1)).drawSpecialBox(new Position(29,10));
        Mockito.verify(gui, Mockito.times(2)).drawSpecialBox(Mockito.any(Position.class));
    }

    @Test
    public void refresh() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    public void clear() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).clear();
    }
}
