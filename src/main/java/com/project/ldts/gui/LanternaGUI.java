package com.project.ldts.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.project.ldts.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class LanternaGUI implements GUI {
    final Screen screen;
    KeyStroke keyStroke;
    String nome = "";

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    public ACTION getNextAction() throws IOException {
        keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 's') return ACTION.SHOT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'c') return ACTION.COLLECT;

        return ACTION.NONE;
    }

    @Override
    public void drawSpecialBox(Position position){
        drawCharacter(position.getX(), position.getY(), 'b', "#553107", "#E28112");
    }

    @Override
    public void drawBullet(Position position) {
        drawCharacter(position.getX(), position.getY(), '*', "#711E09", "#ECEC13");
    }
    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawFirstRow(int health, String minutes, char power, String seconds, int enemies){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FBFAFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(5, 0, "Health: " +health);
        graphics.putString(25, 0, minutes+ ":" +seconds);
        graphics.putString(40, 0, "Enemies: " +enemies);

        if(power == 'p')
            graphics.setForegroundColor(TextColor.Factory.fromString("#920C89"));
        if(power == 't')
            graphics.setForegroundColor(TextColor.Factory.fromString("#6DD6F3"));
        if(power == 'i')
            graphics.setForegroundColor(TextColor.Factory.fromString("#EEC72B"));

        graphics.putString(19, 0, ""+power);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public String drawWinnerScoreMenu() {
        TextGraphics graphics = menuBackground();
        drawWinnerScoreTexts(graphics);
        return nome;
    }

    public void drawCharacter(int x, int y, char c, String colorB, String colorF) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(colorB));
        graphics.setForegroundColor(TextColor.Factory.fromString(colorF));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(x, y, "" + c);
    }

    public void drawAboutTexts(TextGraphics graphics){
        graphics.putString(5,3,"LDTS Project - LEIC FEUP");
        graphics.putString(1,6,"This project consists of a surviving game");
        graphics.putString(1,7,"being played in offline mode");
        graphics.putString(1,8,"on designed arenas.");
        graphics.putString(1,10,"In order to survive and win the game the player");
        graphics.putString(1,11,"has to destroy all the enemies ");
        graphics.putString(1,12,"before he runs out of time!");
        graphics.putString(5,15,"Project developed by:");
        graphics.putString(6,17,"- Elton Tamele (up201908676)");
        graphics.putString(6,19,"- Maureen Ah-shu (up201708043)");
    }

    public void drawInstructionsTexts(TextGraphics graphics){
        graphics.putString(1,5, "MOVE - use the arrow keys for any direction.");
        graphics.putString(1,7, "DESTROY - press 's' to shoot.");
        graphics.putString(1,9, "HIDE - hide in the water to survive.");
        graphics.putString(1,11, "SAFE HOUSE - increase one life at the safe houses.");
        graphics.putString(1,13, "SAME POSITION - If the enemy get to your position");
        graphics.putString(1,14, "                you lose one life.");
        graphics.putString(1,16, "COLLECT - press 'c' when next to a box");
        graphics.putString(1,17, "          to get special powers.");
        graphics.putString(1,19, "QUIT - press 'q' to close the game.");
        graphics.putString(1,23, "NOTE: turn off capslock while playing!");
    }

    public void drawScoresText(TextGraphics graphics, HashMap<String, Integer> map){
        List<Map.Entry<String, Integer> > list = new LinkedList<>(map.entrySet());

        int pos = 0;
        for (Map.Entry<String, Integer> aux : list) {
            graphics.putString(22, 11 + (pos + pos),
                    (pos+1)+ " " +aux.getKey()+ " : " +aux.getValue(), SGR.BOLD);
            pos++;
        }
    }

    public void drawWinnerTexts(TextGraphics graphics, int score){
        graphics.setForegroundColor(TextColor.Factory.fromString("#E28C12"));
        graphics.putString(17, 10, "W   I   N   N   E   R", SGR.BOLD, SGR.BORDERED);
        graphics.setForegroundColor(TextColor.Factory.fromString("#F2B55A"));
        graphics.putString(19, 13, "Your Score:");
        graphics.setForegroundColor(TextColor.Factory.fromString("#E28C12"));
        graphics.putString(32, 13, ""+score);
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
    }

    public void drawWinnerScoreTexts(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#E28C12"));
        graphics.putString(17, 8, "W   I   N   N   E   R", SGR.BOLD, SGR.BORDERED);
        graphics.putString(18, 10, "TOP 5 HIGHEST SCORE", SGR.BOLD, SGR.BORDERED);
        graphics.setForegroundColor(TextColor.Factory.fromString("#B8E4F9"));
        graphics.putString(20, 14, "enter your name:");
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        if(keyStroke != null && keyStroke.getKeyType() == KeyType.Character)
            nome += keyStroke.getCharacter();
        if(keyStroke != null && keyStroke.getKeyType() == KeyType.Backspace && nome.length() > 0)
            nome = nome.substring(0, nome.length() - 1);
        graphics.putString(22, 17, ""+nome);
    }

    public void arenaMenuText(TextGraphics graphics){
        graphics.putString(12, 5, "      S  U  R  V  I  V  E      ", SGR.REVERSE, SGR.BOLD, SGR.BORDERED);
        graphics.setForegroundColor(TextColor.Factory.fromString("#89D1F5"));
        graphics.putString(19, 7, "CHOOSE YOUR ARENA", SGR.BOLD, SGR.BORDERED);
    }

    public void scoreMenuText(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#E28C12"));
        graphics.putString(20, 5, nome+" Scores", SGR.BOLD, SGR.BORDERED);
        graphics.putString(26, 7, "TOP 5", SGR.BOLD);
    }

    public void arenaScoreMenuText(TextGraphics graphics){
        graphics.putString(20, 5, "SURVIVE SCORES", SGR.BOLD, SGR.ITALIC);
        graphics.setForegroundColor(TextColor.Factory.fromString("#E28C12"));
        graphics.putString(13, 8, "WICH ARENA DO YOU WANT TO SEE?", SGR.BOLD, SGR.BORDERED);
    }

    public void loserMenuText(TextGraphics graphics){
        graphics.fillRectangle(new TerminalPosition(0, 1), new TerminalSize(55, 30), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#D01111"));
        graphics.putString(15, 12, "G  A  M  E     O  V  E  R", SGR.BOLD, SGR.BORDERED);
    }

    public abstract TextGraphics menuBackground();
}
