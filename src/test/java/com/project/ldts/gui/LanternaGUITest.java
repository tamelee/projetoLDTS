package com.project.ldts.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.project.ldts.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics graphics;

    @BeforeEach
    public void setUp(){
        screen = Mockito.mock(Screen.class);

        graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);
        gui = new DarkGUI(screen);
    }

    @Test
    public void clear(){
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    public void close() throws IOException {
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }

    @Test
    public void refresh() throws IOException {
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    public void drawFirstRow(){
        gui.drawFirstRow(5, "05", ' ', "00", 6);
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#000000"));
    }

    @Test
    public void drawText(){
        gui.drawText(new Position(10, 10), "JUnit Tests", "#000000");
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphics, Mockito.times(1)).putString(10, 10, "JUnit Tests");
    }

    @Test
    public void nextAction() throws IOException {
        assertEquals(gui.getNextAction(), GUI.ACTION.NONE);
    }
}
