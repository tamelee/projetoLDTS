package com.project.ldts.viewer.game;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.elements.Player;
import com.project.ldts.model.game.arena.Arena;

public class PlayerViewer implements ElementViewer<Player> {
    private final Arena arena;
    public PlayerViewer(Arena arena){
        this.arena = arena;
    }

    @Override
    public void draw(Player player, GUI gui) {
        if(arena.whereToDraw(player.getPosition()) == 's')
            gui.drawOnSand(player.getPosition(), 'X', "#DE5912");
        if(arena.whereToDraw(player.getPosition()) == 'w')
            gui.drawOnWater(player.getPosition(), 'X');
        if(arena.whereToDraw(player.getPosition()) == 'f')
            gui.drawPlayer(player.getPosition());
    }
}
