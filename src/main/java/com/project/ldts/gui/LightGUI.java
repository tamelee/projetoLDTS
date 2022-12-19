package com.project.ldts.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.project.ldts.model.Position;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class LightGUI extends LanternaGUI{
    public LightGUI(Screen screen) {
        super(screen);
    }

    public LightGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        super(width, height);
    }

    @Override
    public void drawPlayer(Position position) {
        background = "#58BD0F";
        foreground = "#DE5912";
        drawCharacter(position, 'X');
    }

    @Override
    public void drawEnemy(Position position) {
        background = "#58BD0F";
        foreground = "#620D9C";
        drawCharacter(position, '@');
    }

    @Override
    public void drawOnWater(Position position, char c){
        background = "#5AD3F2";
        foreground = "#11B0D0";
        drawCharacter(position, c);
    }

    @Override
    public void drawOnSand(Position position, char c, String color){
        background = "#F1A855";
        foreground = color;
        drawCharacter(position, c);
    }

    @Override
    public void drawWall(Position position) {
        background = "#448E0B";
        foreground = "#DE5912";
        drawCharacter(position, '☒');
    }

    @Override
    public void drawWater(Position position) {
        background = "#5AD3F2";
        foreground = "#11B0D0";
        drawCharacter(position, '~');
    }

    @Override
    public void drawSand(Position position) {
        background = "#F1A855";
        foreground = "#E28112";
        drawCharacter(position, '.');
    }

    @Override
    public void drawSafeHouse(Position position) {
        background = "#FEF6F7";
        foreground = "#D41111";
        drawCharacter(position, '+');
    }

    @Override
    public void drawArenaFloor(int width, int height, char c){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#58BD0F"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#448E0B"));
        graphics.fillRectangle(new TerminalPosition(0, 1), new TerminalSize(width, height), c);
    }

    @Override
    public void drawMainMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#083663"));
        graphics.putString(18, 5, "S  U  R  V  I  V  E", SGR.BLINK, SGR.BOLD, SGR.CROSSED_OUT, SGR.BORDERED);
        graphics.setForegroundColor(TextColor.Factory.fromString("#083663"));
        graphics.putString(18, 12, "      M E N U      ", SGR.BOLD, SGR.REVERSE);
    }

    @Override
    public void drawAboutMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#083663"));
        drawAboutTexts(graphics);
    }

    @Override
    public void drawInstructionsMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#0A3F7B"));
        graphics.putString(3,3, "GAME INSTRUCTIONS:", SGR.REVERSE);
        graphics.setForegroundColor(TextColor.Factory.fromString("#083663"));
        drawInstructionsTexts(graphics);
    }

    @Override
    public void drawScoreMenu(String nome, HashMap<String, Integer> map){
        TextGraphics graphics = menuBackground();
        scoreMenuText(graphics);
        graphics.setForegroundColor(TextColor.Factory.fromString("#083663"));

        drawScoresText(graphics, map);
    }

    @Override
    public void drawArenaScoreMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#083663"));
        arenaScoreMenuText(graphics);
    }

    @Override
    public void drawLoserMenu(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#2BDEEE"));
        loserMenuText(graphics);
    }

    @Override
    public void drawWinnerMenu(int score){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#2BDEEE"));
        graphics.fillRectangle(new TerminalPosition(0, 1), new TerminalSize(55, 30), ' ');
        drawWinnerTexts(graphics, score);
    }

    @Override
    public void drawArenasMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#083663"));
        arenaMenuText(graphics);
    }

    @Override
    public void drawSettingsMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#083663"));
        graphics.putString(18,6,"  S E T T I N G S  ", SGR.REVERSE);
    }

    @Override
    public TextGraphics menuBackground(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#89D1F5"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(55, 30), ' ');
        return graphics;
    }
}
