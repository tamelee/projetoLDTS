package com.project.ldts.model;

import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.scores.ScoreReader;
import com.project.ldts.model.menu.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    @Test
    public void mainMenu(){
        MainMenu menu = new MainMenu();
        assertNotEquals(menu.getNumberEntries(), 0);
        assertTrue(menu.isSelectedStart());
        menu.previousEntry();
        assertTrue(menu.isSelectedExit());
        menu.nextEntry();
        assertTrue(menu.isSelectedStart());
        menu.nextEntry();

        assertFalse(menu.isSelectedStart());

        assertTrue(menu.isSelectedScores());
        menu.nextEntry();
        assertTrue(menu.isSelectedInstructions());
        menu.nextEntry();
        assertTrue(menu.isSelectedSettings());
        menu.nextEntry();
        assertTrue(menu.isSelectedAbout());
        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedStart());

        assertFalse(menu.isSelectedSettings());
        assertFalse(menu.isSelectedInstructions());
        assertFalse(menu.isSelectedScores());
        assertFalse(menu.isSelectedAbout());
        assertFalse(menu.isSelectedExit());

        assertEquals(menu.getEntry(3), "Settings");
        assertEquals(menu.getEntry(4), "About");
        assertEquals(menu.getEntry(5), "Exit");
    }

    @Test
    public void menuArenas(){
        MenuArenas menu = new MenuArenas();
        assertNotEquals(menu.getNumberEntries(), 0);
        menu.previousXEntry();
        assertTrue(menu.isSelectedBack());
        menu.previousYEntry();

        assertFalse(menu.isSelectedPeach());

        assertTrue(menu.isSelectedGraveyard());
        menu.nextXEntry();
        assertTrue(menu.isSelectedDarkPrison());
        menu.previousYEntry();
        assertTrue(menu.isSelectedMokey());
        menu.nextXEntry();
        assertTrue(menu.isSelectedMidnight());
        menu.nextYEntry();
        assertTrue(menu.isSelectedPeach());

        assertFalse(menu.isSelectedBack());
        assertFalse(menu.isSelectedGraveyard());
        assertFalse(menu.isSelectedDarkPrison());
        assertFalse(menu.isSelectedMidnight());
        assertFalse(menu.isSelectedMokey());

        assertEquals(menu.getEntry(0), "MOKEY");
        assertEquals(menu.getEntry(3), "DARK PRISON");
        assertEquals(menu.getEntry(5), "back");
    }

    @Test
    public void menuSettings(){
        MenuSettings menu = new MenuSettings();
        assertNotEquals(menu.getNumberEntries(), 0);
        assertTrue(menu.isSelectedTurnOn());
        menu.previousEntry();
        assertTrue(menu.isSelectedReturn());

        assertFalse(menu.isSelectedTurnOn());

        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedTurnOff());
        menu.nextEntry();
        assertTrue(menu.isSelectedLightMode());
        menu.nextEntry();
        assertTrue(menu.isSelectedDarkMode());
        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedTurnOn());

        assertFalse(menu.isSelectedTurnOff());
        assertFalse(menu.isSelectedLightMode());
        assertFalse(menu.isSelectedDarkMode());
        assertFalse(menu.isSelectedReturn());

        assertEquals(menu.getEntry(0), "TURN ON Sound");
        assertEquals(menu.getEntry(2), "LIGHT Mode");
        assertEquals(menu.getEntry(4), "Return");
    }

    @Test
    public void menuLoser(){
        Arena arena = Mockito.mock(Arena.class);
        MenuLoser menu = new MenuLoser(arena);
        assertNotEquals(menu.getNumberEntries(), 0);
        assertTrue(menu.isSelectedRestart());
        menu.previousEntry();
        assertTrue(menu.isSelectedExit());

        assertFalse(menu.isSelectedRestart());

        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedMenu());
        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedRestart());

        assertFalse(menu.isSelectedExit());
        assertFalse(menu.isSelectedMenu());

        assertEquals(menu.getEntry(0), "Restart");
        assertEquals(menu.getEntry(1), "Back To Menu");
        assertEquals(menu.getEntry(2), "Exit");
    }

    @Test
    public void menuWinner(){
        Arena arena = Mockito.mock(Arena.class);
        MenuWinner menu = new MenuWinner(arena);
        assertNotEquals(menu.getNumberEntries(), 0);
        assertTrue(menu.isSelectedRestart());
        menu.previousEntry();
        assertTrue(menu.isSelectedExit());

        assertFalse(menu.isSelectedRestart());

        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedScores());
        menu.nextEntry();
        assertTrue(menu.isSelectedMenu());
        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedRestart());

        assertFalse(menu.isSelectedExit());
        assertFalse(menu.isSelectedScores());
        assertFalse(menu.isSelectedMenu());

        assertEquals(menu.getEntry(0), "Play Again");
        assertEquals(menu.getEntry(1), "High Scores");
        assertEquals(menu.getEntry(2), "Back To Menu");
        assertEquals(menu.getEntry(3), "Exit");
    }

    @Test
    public void menuWinnerScore(){
        Arena arena = Mockito.mock(Arena.class);
        ScoreReader scoreReader = Mockito.mock(ScoreReader.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Maureen", 250);
        map.put("Elton", 200);

        Mockito.when(scoreReader.getScores()).thenReturn(map);
        MenuWinnerScore menu = new MenuWinnerScore(arena, scoreReader);

        assertNotEquals(menu.getNumberEntries(), 0);
        assertTrue(menu.isSelectedSave());
        menu.previousEntry();
        assertTrue(menu.isSelectedExit());

        assertFalse(menu.isSelectedSave());

        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedMenu());
        menu.nextEntry();
        menu.nextEntry();
        assertTrue(menu.isSelectedSave());

        assertFalse(menu.isSelectedExit());
        assertFalse(menu.isSelectedMenu());

        assertEquals(menu.getEntry(0), "SAVE");
        assertEquals(menu.getEntry(1), "MENU");
        assertEquals(menu.getEntry(2), "EXIT");

        assertEquals(menu.getScore(), scoreReader);
    }
}
