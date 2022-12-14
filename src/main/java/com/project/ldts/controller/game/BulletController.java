package com.project.ldts.controller.game;

import com.project.ldts.Application;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.Bullet;

public class BulletController extends GameController {
    private long lastBulletMovement;

    public BulletController(Arena arena) {
        super(arena);

        this.lastBulletMovement = 0;
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time)  {
        if (time - lastBulletMovement > 100) {
            for (Bullet bullet: getModel().getBullets()) {
                bullet.setPosition(bullet.move());
                getModel().verifyHit(bullet);
            }
            this.lastBulletMovement = time;
        }
    }
}