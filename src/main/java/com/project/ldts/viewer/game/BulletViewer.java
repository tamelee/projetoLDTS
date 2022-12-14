package com.project.ldts.viewer.game;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.elements.Bullet;

public class BulletViewer implements ElementViewer<Bullet> {

    @Override
    public void draw(Bullet bullet, GUI gui) {
        gui.drawBullet(bullet.getPosition());
    }
}
