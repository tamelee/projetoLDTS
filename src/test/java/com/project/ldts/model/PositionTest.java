package com.project.ldts.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private int x;
    private int y;

    @BeforeEach
    public void setUp(){
        x = 10;
        y = 10;
    }

    @Test
    public void getUp(){
        assertEquals(y-1, new Position(x, y).getUp().getY());
        assertEquals(x, new Position(x,y).getUp().getX());
    }

    @Test
    public void getDown(){
        assertEquals(y+1, new Position(x, y).getDown().getY());
        assertEquals(x, new Position(x,y).getDown().getX());
    }

    @Test
    public void getRight(){
        assertEquals(x+1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x,y).getRight().getY());
    }

    @Test
    public void getLeft(){
        assertEquals(x-1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x,y).getLeft().getY());
    }

    @Test
    public void checkIfNear(){
        Position pos = new Position(10, 10);
        assertTrue(pos.checkIfNear(new Position(10, 11)));
        assertTrue(pos.checkIfNear(new Position(9, 10)));
        assertFalse(pos.checkIfNear(new Position(13, 10)));
    }
}
