package com.project.ldts.viewer.game;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.elements.SpecialBox;

public class SpecialBoxViewer implements ElementViewer<SpecialBox> {

    @Override
    public void draw(SpecialBox element, GUI gui) {
        gui.drawSpecialBox(element.getPosition());
    }
}
