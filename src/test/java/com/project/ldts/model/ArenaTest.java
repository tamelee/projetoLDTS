package com.project.ldts.model;

import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.arena.ArenaBuilder;
import com.project.ldts.model.game.arena.ArenaLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ArenaTest {

    @Test
    public void arenaLoader() throws IOException {
        ArenaLoader arena = new ArenaLoader("Midnight");
        arena.createArena();

        assertEquals(arena.getHeight(), 30);
        assertEquals(arena.getWidth(), 55);
    }

    @Test
    public void arenaBuilder() throws IOException {
        ArenaBuilder arenaBuilder = new ArenaLoader("Midnight");
        Arena arena = arenaBuilder.createArena();

        assertNotEquals(arena.getEnemies().size(), 0);
        assertNotEquals(arena.getWalls().size(), 0);
        assertNotEquals(arena.getSpecialBoxes().size(), 0);
        assertNotEquals(arena.getWaters().size(), 0);
        assertNotEquals(arena.getPlayer(), null);
    }
}
