package com.project.ldts.states;

import com.project.ldts.controller.Controller;
import com.project.ldts.controller.game.ArenaController;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.viewer.Viewer;
import com.project.ldts.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
