package com.project.ldts.states;

import com.project.ldts.model.game.arena.Arena;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameStateTest {

    @Test
    public void gameState(){
        Arena arena = Mockito.mock(Arena.class);
        GameState game = new GameState(arena);
        assertNotEquals(game.getViewer(), null);
        assertNotEquals(game.getController(), null);
    }
}
