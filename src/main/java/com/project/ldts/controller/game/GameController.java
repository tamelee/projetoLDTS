package com.project.ldts.controller.game;

import com.project.ldts.controller.Controller;
import com.project.ldts.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}