package com.project.ldts.model;

import com.project.ldts.model.game.elements.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementsTest {

    @Test
    public void player(){
        Player player = new Player(10, 10);
        assertEquals(player.getName(), "Unkown");
        assertEquals(player.getDirection(), ' ');
        assertEquals(player.getHealth(), 5);

        player.increaseHealth();
        assertEquals(player.getHealth(), 5);

        player.decreaseHealth();
        assertEquals(player.getHealth(), 4);

        player.increaseHealth();
        assertEquals(player.getHealth(), 5);
    }

    @Test
    public void enemy(){
        Enemy enemy = new Enemy(10, 10);

        assertEquals(enemy.getHealth(), 3);

        enemy.increaseHealth();
        assertEquals(enemy.getHealth(), 3);

        enemy.decreaseHealth();
        assertEquals(enemy.getHealth(), 2);

        enemy.increaseHealth();
        assertEquals(enemy.getHealth(), 3);
    }

    @Test
    public void safeHouse(){
        SafeHouse safeHouse = new SafeHouse(10, 10);

        assertTrue(safeHouse.isActive());

        safeHouse.setActive(false);

        assertFalse(safeHouse.isActive());
    }

    @Test
    public void specialBox(){
        SpecialBox specialBox = new SpecialBox(10, 10);

        assertFalse(specialBox.isUsed());

        specialBox.setUsed(true);

        assertTrue(specialBox.isUsed());
    }

    @Test
    public void bullets(){
        Bullet bullet = new Bullet(10, 10, 'r');
        assertEquals(new Position(11, 10), bullet.move());

        bullet = new Bullet(10, 10, 'l');
        assertEquals(new Position(9, 10), bullet.move());

        bullet = new Bullet(10, 10, 'u');
        assertEquals(new Position(10, 9), bullet.move());

        bullet = new Bullet(10, 10, 'd');
        assertEquals(new Position(10, 11), bullet.move());
    }
}
