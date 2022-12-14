package com.project.ldts.controller.game;

import com.project.ldts.Application;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Position;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.Enemy;

public class EnemyController extends GameController {
    private long lastEnemyMovement;
    private long lastEnemyAttack;

    public EnemyController(Arena arena) {
        super(arena);

        this.lastEnemyMovement = 0;
        this.lastEnemyAttack = 0;
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) {
        if (time - lastEnemyMovement > 500) {
            for (Enemy enemy: getModel().getEnemies()) {
                if(enemy.getHealth() < 1)
                    getModel().getEnemies().remove(enemy);
                if(getModel().getPower() != 't'){
                    moveEnemies(enemy, enemy.getPosition().getRandomNeighbour());
                    getModel().playerEnemyCollision(enemy);
                }
            }
            this.lastEnemyMovement = time;
        }
    }

    private void moveEnemies(Enemy enemy, Position position){
        if (getModel().canMove(position))
            enemy.setPosition(position);
    }

    public void enemyAttack(long time){
        if(getModel().getPower() != 't'){
            if (time - lastEnemyAttack > 500) {
                for (Enemy enemy : getModel().getEnemies()) getModel().fireEnemyShots(enemy);
                this.lastEnemyAttack = time;
            }
        }
    }
}