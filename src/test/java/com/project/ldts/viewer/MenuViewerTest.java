package com.project.ldts.viewer;

import com.project.ldts.gui.GUI;
import com.project.ldts.model.game.arena.Arena;
import com.project.ldts.model.game.elements.Enemy;
import com.project.ldts.model.game.elements.Player;
import com.project.ldts.model.game.scores.ScoreReader;
import com.project.ldts.model.menu.*;
import com.project.ldts.viewer.menu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class MenuViewerTest {
    private GUI gui;
    private Arena arena;
    private MenuAboutViewer about;
    private MenuArenasViewer arenas;
    private MenuArenaScoreViewer arenaScore;
    private MenuInstructionsViewer instructions;
    private MenuLoserViewer loser;
    private MenuWinnerViewer winner;
    private MenuWinnerScoreViewer winnerScore;
    private MenuSettingsViewer settings;
    private MenuScoreViewer score;

    @BeforeEach
    public void setUp(){
        arena = new Arena(30, 15);
        ScoreReader sr = Mockito.mock(ScoreReader.class);
        gui = Mockito.mock(GUI.class);

        about = new MenuAboutViewer(new MenuInfo());
        arenas = new MenuArenasViewer(new MenuArenas());
        arenaScore = new MenuArenaScoreViewer(new MenuArenas());
        instructions = new MenuInstructionsViewer(new MenuInfo());
        loser = new MenuLoserViewer(new MenuLoser(arena));
        winner = new MenuWinnerViewer(new MenuWinner(arena));
        settings = new MenuSettingsViewer(new MenuSettings());
        winnerScore = new MenuWinnerScoreViewer(new MenuWinnerScore(arena, sr));
        score = new MenuScoreViewer(new MenuInfo("Graveyard", sr));
    }

    @Test
    public void mainMenuViewer() throws IOException {
        MainMenu model = Mockito.mock(MainMenu.class);
        Mockito.when(model.isSelected(0)).thenReturn(true);
        MainMenuViewer main = new MainMenuViewer(model);
        main.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawMainMenu();
        Mockito.verify(model, Mockito.atLeastOnce()).getNumberEntries();
    }

    @Test
    public void aboutMenuViewer() throws IOException {
        about.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawAboutMenu();
    }

    @Test
    public void arenasMenuViewer() throws IOException {
        arenas.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawArenasMenu();
    }

    @Test
    public void arenaScoreMenuViewer() throws IOException {
        arenaScore.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawArenaScoreMenu();
    }

    @Test
    public void instructionsMenuViewer() throws IOException {
        instructions.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawInstructionsMenu();
    }

    @Test
    public void loserMenuViewer() throws IOException {
        arena.setPlayer(new Player(10, 10));
        arena.setEnemies(Arrays.asList(new Enemy(2,3), new Enemy(10,11)));
        loser.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawLoserMenu();
    }

    @Test
    public void winnerMenuViewer() throws IOException {
        Player player = new Player(10, 10);
        player.setScore(50);
        arena.setPlayer(player);
        arena.setEnemies(Arrays.asList(new Enemy(2,3), new Enemy(10,11)));
        winner.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawWinnerMenu(50);
    }

    @Test
    public void settingsMenuViewer() throws IOException {
        settings.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawSettingsMenu();
    }

    @Test
    public void winnerScoreMenuViewer() throws IOException {
        Player player = new Player(10, 10);
        player.setScore(50);
        arena.setPlayer(player);
        winnerScore.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawWinnerScoreMenu();
    }

    @Test
    public void scoreMenuViewer() throws IOException {
        score.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawScoreMenu("Graveyard",new HashMap<>());
    }
}
