package com.project.ldts;

import com.project.ldts.gui.DarkGUI;
import com.project.ldts.gui.LanternaGUI;
import com.project.ldts.model.menu.MainMenu;
import com.project.ldts.states.menu.MainMenuState;
import com.project.ldts.states.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private LanternaGUI gui;
    private State state;
    private String arena;
    private boolean sound;

    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new DarkGUI(55, 30);
        this.state = new MainMenuState(new MainMenu());
        this.sound = true;
    }

    public static void main (String [] args) throws IOException, URISyntaxException, FontFormatException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        new Application().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getArena() {return arena;}
    public void setArena(String arena) {this.arena = arena;}

    public boolean isSound() {return sound;}
    public void setSound(boolean sound) {this.sound = sound;}

    public void setGui(LanternaGUI gui) {this.gui = gui;}
    public LanternaGUI getGui() {return gui;}

    public void start() throws IOException, UnsupportedAudioFileException, LineUnavailableException, URISyntaxException, FontFormatException, InterruptedException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);
        }
        gui.close();
    }
}
