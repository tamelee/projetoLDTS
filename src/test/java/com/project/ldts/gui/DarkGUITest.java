package com.project.ldts.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.project.ldts.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;

public class DarkGUITest {
    private LanternaGUI gui;
    private TextGraphics graphics;

    @BeforeEach
    public void setUp(){
        Screen screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);
        gui = new DarkGUI(screen);
    }

    @Test
    public void drawPlayer(){
        gui.drawPlayer(new Position(10, 10));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#84540B")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#DE5912")));
        Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphics, Mockito.times(1)).putString(10,10, "X");
    }

    @Test
    public void drawEnemy(){
        gui.drawEnemy(new Position(10, 10));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#84540B")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#620D9C")));
        Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphics, Mockito.times(1)).putString(10,10, "@");
    }

    @Test
    public void drawSettings(){
        gui.drawSettingsMenu();
        Mockito.verify(graphics, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(55, 30), ' ');
    }

    @Test
    public void drawOnWater(){
        gui.drawOnWater(new Position(10,10), 'X');
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#10C16E")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#0EAA54")));
        Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphics, Mockito.times(1)).putString(10,10, "X");
    }

    @Test
    public void drawOnSand(){
        gui.drawOnSand(new Position(10,10), 'X', "#DE5912");
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#F1A855")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#DE5912")));
        Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphics, Mockito.times(1)).putString(10,10, "X");
    }

    @Test
    public void drawWall(){
        gui.drawWall(new Position(10,10));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#76430A")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#2F1904")));
    }

    @Test
    public void drawWater(){
        gui.drawWater(new Position(10,10));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#10C16E")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#0EAA54")));
    }

    @Test
    public void drawSand(){
        gui.drawSand(new Position(10,10));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#F1A855")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#E28112")));
    }

    @Test
    public void drawSpecialBox(){
        gui.drawSpecialBox(new Position(10,10));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#553107")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#E28112")));
    }

    @Test
    public void drawSafeHouse(){
        gui.drawSafeHouse(new Position(10,10));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#D41111")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#FEF6F7")));
    }

    @Test
    public void drawBullet(){
        gui.drawBullet(new Position(10,10));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#711E09")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#ECEC13")));
    }

    @Test
    public void drawArenaFloor(){
        gui.drawArenaFloor(30, 15, ',');
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor((TextColor.Factory.fromString("#84540B")));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor((TextColor.Factory.fromString("#422405")));
    }

    @Test
    public void drawMainMenu(){
        gui.drawMainMenu();
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#2FBBEE"));
    }

    @Test
    public void drawAboutMenu(){
        gui.drawAboutMenu();
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#B8E4F9"));
    }

    @Test
    public void drawInstructionsMenu(){
        gui.drawInstructionsMenu();
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#0A3F7B"));
    }

    @Test
    public void drawScoreMenu(){
        gui.drawScoreMenu(" ", new HashMap<>());
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#E28C12"));
    }

    @Test
    public void drawArenaScoreMenu(){
        gui.drawArenaScoreMenu();
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#B8E4F9"));
    }

    @Test
    public void drawLoserMenu(){
        gui.drawLoserMenu();
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#052039"));
    }

    @Test
    public void drawWinnerMenu(){
        gui.drawWinnerMenu(100);
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#052039"));
    }

    @Test
    public void drawArenasMenu(){
        gui.drawArenasMenu();
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#2FBBEE"));
    }

    @Test
    public void drawWinnerScore(){
        gui.drawWinnerScoreMenu();
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#052039"));
    }
}
