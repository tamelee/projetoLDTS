package com.project.ldts.controller;

import com.project.ldts.Application;
import com.project.ldts.controller.menu.*;
import com.project.ldts.gui.GUI;
import com.project.ldts.model.Sound;
import com.project.ldts.model.menu.*;
import com.project.ldts.states.menu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuControllerTest {
    private Application game;

    @BeforeEach
    public void setUp(){
        game = Mockito.mock(Application.class);
    }

    @Test
    public void mainMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MainMenu model = Mockito.mock(MainMenu.class);
        MainMenuState state = new MainMenuState(model);
        game.setState(state);
        MainMenuController mainMenu = new MainMenuController(model);

        mainMenu.step(game, GUI.ACTION.DOWN, 1000);
        Mockito.verify(model, Mockito.times(1)).nextEntry();

        mainMenu.step(game, GUI.ACTION.UP, 1000);
        Mockito.verify(model, Mockito.times(1)).previousEntry();

        mainMenu.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(1)).isSelectedAbout();
        Mockito.verify(model, Mockito.times(1)).isSelectedExit();
        Mockito.verify(model, Mockito.times(1)).isSelectedInstructions();
        Mockito.verify(model, Mockito.times(1)).isSelectedScores();
        Mockito.verify(model, Mockito.times(1)).isSelectedSettings();
        Mockito.verify(model, Mockito.times(1)).isSelectedStart();
    }

    @Test
    public void arenasMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MenuArenas model = Mockito.mock(MenuArenas.class);
        MenuArenasState state = new MenuArenasState(model);
        game.setState(state);
        MenuArenasController controller = new MenuArenasController(model);

        controller.step(game, GUI.ACTION.DOWN, 1000);
        Mockito.verify(model, Mockito.times(1)).nextYEntry();

        controller.step(game, GUI.ACTION.UP, 1000);
        Mockito.verify(model, Mockito.times(1)).previousYEntry();

        controller.step(game, GUI.ACTION.RIGHT, 1000);
        Mockito.verify(model, Mockito.times(1)).nextXEntry();

        controller.step(game, GUI.ACTION.LEFT, 1000);
        Mockito.verify(model, Mockito.times(1)).previousXEntry();

        controller.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(1)).isSelectedBack();
        Mockito.verify(model, Mockito.times(1)).isSelectedDarkPrison();
        Mockito.verify(model, Mockito.times(1)).isSelectedGraveyard();
        Mockito.verify(model, Mockito.times(1)).isSelectedMokey();
        Mockito.verify(model, Mockito.times(1)).isSelectedPeach();
        Mockito.verify(model, Mockito.times(1)).isSelectedMidnight();
    }

    @Test
    public void arenaScoreMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MenuArenas model = Mockito.mock(MenuArenas.class);
        MenuArenasScoreState state = new MenuArenasScoreState(model);
        game.setState(state);
        MenuArenaScoreController controller = new MenuArenaScoreController(model);

        controller.step(game, GUI.ACTION.DOWN, 1000);
        Mockito.verify(model, Mockito.times(1)).nextXEntry();

        controller.step(game, GUI.ACTION.UP, 1000);
        Mockito.verify(model, Mockito.times(1)).previousXEntry();
    }

    @Test
    public void instructionsMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MenuInfo model = Mockito.mock(MenuInfo.class);
        MenuInfoState state = new MenuInstructionsState(model);
        game.setState(state);
        MenuInfoController controller = new MenuInfoController(model);

        controller.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(0)).isSelected(0);
    }

    @Test
    public void aboutMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MenuInfo model = Mockito.mock(MenuInfo.class);
        MenuInfoState state = new MenuAboutState(model);
        game.setState(state);
        MenuInfoController controller = new MenuInfoController(model);

        controller.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(0)).isSelected(0);
    }

    @Test
    public void scoreMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MenuInfo model = Mockito.mock(MenuInfo.class);
        MenuInfoState state = new MenuScoreState(model);
        game.setState(state);
        MenuInfoController controller = new MenuInfoController(model);

        controller.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(0)).isSelected(0);
    }

    @Test
    public void loserMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MenuLoser model = Mockito.mock(MenuLoser.class);
        MenuLoserState state = new MenuLoserState(model);
        game.setState(state);
        MenuLoserController controller = new MenuLoserController(model);

        controller.step(game, GUI.ACTION.DOWN, 1000);
        Mockito.verify(model, Mockito.times(1)).nextEntry();

        controller.step(game, GUI.ACTION.UP, 1000);
        Mockito.verify(model, Mockito.times(1)).previousEntry();

        controller.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(1)).isSelectedMenu();
        Mockito.verify(model, Mockito.times(1)).isSelectedRestart();
        Mockito.verify(model, Mockito.times(1)).isSelectedExit();
    }

    @Test
    public void settingsMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException, URISyntaxException, FontFormatException {
        MenuSettings model = Mockito.mock(MenuSettings.class);
        MenuSettingState state = new MenuSettingState(model);
        game.setState(state);
        MenuSettingsController controller = new MenuSettingsController(model);

        controller.step(game, GUI.ACTION.DOWN, 1000);
        Mockito.verify(model, Mockito.times(1)).nextEntry();

        controller.step(game, GUI.ACTION.UP, 1000);
        Mockito.verify(model, Mockito.times(1)).previousEntry();

        controller.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(1)).isSelectedDarkMode();
        Mockito.verify(model, Mockito.times(1)).isSelectedLightMode();
        Mockito.verify(model, Mockito.times(1)).isSelectedTurnOff();
        Mockito.verify(model, Mockito.times(1)).isSelectedTurnOn();
        Mockito.verify(model, Mockito.times(1)).isSelectedReturn();
    }

    @Test
    public void winnerMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MenuWinner model = Mockito.mock(MenuWinner.class);
        MenuWinnerState state = new MenuWinnerState(model);
        game.setState(state);
        MenuWinnerController controller = new MenuWinnerController(model);

        controller.step(game, GUI.ACTION.DOWN, 1000);
        Mockito.verify(model, Mockito.times(1)).nextEntry();

        controller.step(game, GUI.ACTION.UP, 1000);
        Mockito.verify(model, Mockito.times(1)).previousEntry();

        controller.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(1)).isSelectedMenu();
        Mockito.verify(model, Mockito.times(1)).isSelectedRestart();
        Mockito.verify(model, Mockito.times(1)).isSelectedExit();
    }

    @Test
    public void winnerScoreMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        MenuWinnerScore model = Mockito.mock(MenuWinnerScore.class);
        MenuWinnerScoreState state = new MenuWinnerScoreState(model);
        game.setState(state);
        MenuWinnerScoreController controller = new MenuWinnerScoreController(model);

        controller.step(game, GUI.ACTION.RIGHT, 1000);
        Mockito.verify(model, Mockito.times(1)).nextEntry();

        controller.step(game, GUI.ACTION.LEFT, 1000);
        Mockito.verify(model, Mockito.times(1)).previousEntry();

        controller.step(game, GUI.ACTION.SELECT, 1000);
        Mockito.verify(model, Mockito.times(1)).isSelectedMenu();
        Mockito.verify(model, Mockito.times(1)).isSelectedExit();
    }
}
