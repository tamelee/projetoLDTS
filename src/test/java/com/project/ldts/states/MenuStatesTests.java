package com.project.ldts.states;

import com.project.ldts.model.menu.*;
import com.project.ldts.states.menu.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MenuStatesTests {

    @Test
    public void mainMenuState(){
        MainMenu model = Mockito.mock(MainMenu.class);
        MainMenuState menu = new MainMenuState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void aboutMenuState(){
        MenuInfo model = Mockito.mock(MenuInfo.class);
        MenuAboutState menu = new MenuAboutState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void arenaScoreMenuState(){
        MenuArenas model = Mockito.mock(MenuArenas.class);
        MenuArenasScoreState menu = new MenuArenasScoreState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void arenaMenuState(){
        MenuArenas model = Mockito.mock(MenuArenas.class);
        MenuArenasState menu = new MenuArenasState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void instructionsMenuState(){
        MenuInfo model = Mockito.mock(MenuInfo.class);
        MenuInstructionsState menu = new MenuInstructionsState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void loserMenuState(){
        MenuLoser model = Mockito.mock(MenuLoser.class);
        MenuLoserState menu = new MenuLoserState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void scoreMenuState(){
        MenuInfo model = Mockito.mock(MenuInfo.class);
        MenuScoreState menu = new MenuScoreState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void settingsMenuState(){
        MenuSettings model = Mockito.mock(MenuSettings.class);
        MenuSettingState menu = new MenuSettingState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void winnerMenuState(){
        MenuWinner model = Mockito.mock(MenuWinner.class);
        MenuWinnerState menu = new MenuWinnerState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }

    @Test
    public void winnerScoreMenuState(){
        MenuWinnerScore model = Mockito.mock(MenuWinnerScore.class);
        MenuWinnerScoreState menu = new MenuWinnerScoreState(model);
        assertNotEquals(menu.getViewer(), null);
        assertNotEquals(menu.getController(), null);
    }
}
