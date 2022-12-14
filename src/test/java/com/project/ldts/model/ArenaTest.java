package com.project.ldts.model;

import com.project.ldts.model.game.arena.ArenaLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTest {

    @Test
    public void arenaBuilder() throws IOException {
        ArenaLoader arena = new ArenaLoader("Midnight");
        arena.createArena();

        assertEquals(arena.getHeight(), 30);
        assertEquals(arena.getWidth(), 55);
    }
}
