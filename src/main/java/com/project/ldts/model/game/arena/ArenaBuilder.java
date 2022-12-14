package com.project.ldts.model.game.arena;

import com.project.ldts.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setPlayer(createPlayer());
        arena.setEnemies(createEnemies());
        arena.setWalls(createWalls());
        arena.setSand(createSand());
        arena.setWaters(createWater());
        arena.setSafeHouses(createSafeHouse());
        arena.setSpecialBoxes(createSpecialBox());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Enemy> createEnemies();

    protected abstract Player createPlayer();

    protected abstract List<Sand> createSand();

    protected abstract List<Water> createWater();

    protected abstract List<SafeHouse> createSafeHouse();

    protected abstract List<SpecialBox> createSpecialBox();
}
