package com.project.ldts.viewer.game;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.Enemy;

public class EnemyViewer implements ElementViewer<Enemy>{
    private final Arena arena;

    public EnemyViewer(Arena arena){
        this.arena = arena;
    }

    @Override
    public void draw(Enemy enemy, GUI gui) {
        if(arena.whereToDraw(enemy.getPosition()) == 's')
            gui.drawOnSand(enemy.getPosition(), '@', "#620D9C");
        if(arena.whereToDraw(enemy.getPosition()) == 'w')
            gui.drawOnWater(enemy.getPosition(), '@');
        if(arena.whereToDraw(enemy.getPosition()) == 'f')
            gui.drawEnemy(enemy.getPosition());
    }
}