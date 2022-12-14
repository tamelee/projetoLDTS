package com.project.ldts.controller.game;

import com.project.ldts.Application;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.game.arena.Arena;

public class PlayerController extends GameController {
    public PlayerController(Arena arena) {
        super(arena);
    }

    public void movePlayerLeft() {
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }

    public void movePlayerRight() {
        movePlayer(getModel().getPlayer().getPosition().getRight());
    }

    public void movePlayerUp() {
        movePlayer(getModel().getPlayer().getPosition().getUp());
    }

    public void movePlayerDown() {
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) {
        switch (action) {
            case UP -> { movePlayerUp(); getModel().getPlayer().setDirection('u'); }
            case DOWN -> { movePlayerDown(); getModel().getPlayer().setDirection('d'); }
            case LEFT -> { movePlayerLeft(); getModel().getPlayer().setDirection('l'); }
            case RIGHT -> { movePlayerRight(); getModel().getPlayer().setDirection('r'); }
            case SHOT -> getModel().firePlayerShots();
            case COLLECT -> getModel().collectPower();
        }
    }

    private void movePlayer(Position position) {
        if(getModel().isPlayerAlive()){
            if(getModel().canMove(position)){
                getModel().getPlayer().setPosition(position);
                getModel().safeHouseEffect(position);
            }
        }
    }
}