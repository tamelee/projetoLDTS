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


public class DarkGUI extends LanternaGUI{
    public DarkGUI(Screen screen) {
        super(screen);
    }

    public DarkGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        super(width, height);
    }

    @Override
    public void drawPlayer(Position position) {
        drawCharacter(position.getX(), position.getY(), 'X', "#84540B", "#DE5912");
    }

    @Override
    public void drawEnemy(Position position) {
        drawCharacter(position.getX(), position.getY(), '@', "#84540B", "#620D9C");
    }

    @Override
    public void drawOnWater(Position position, char c){
        drawCharacter(position.getX(), position.getY(), c, "#10C16E", "#0EAA54");
    }

    @Override
    public void drawOnSand(Position position, char c, String color){
        drawCharacter(position.getX(), position.getY(), c, "#F1A855", color);
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '☒', "#76430A", "#2F1904");
    }

    @Override
    public void drawWater(Position position) {
        drawCharacter(position.getX(), position.getY(), '~', "#10C16E", "#0EAA54");
    }

    @Override
    public void drawSand(Position position) {
        drawCharacter(position.getX(), position.getY(), '.', "#F1A855", "#E28112");
    }

    @Override
    public void drawSafeHouse(Position position) {
        drawCharacter(position.getX(), position.getY(), '+', "#D41111", "#FEF6F7");
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

    private void drawCharacter(int x, int y, char c, String colorB, String colorF) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(colorB));
        graphics.setForegroundColor(TextColor.Factory.fromString(colorF));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(x, y, "" + c);
    }

    @Override
    public void drawArenaFloor(int width, int height, char c){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#84540B"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#422405"));
        graphics.fillRectangle(new TerminalPosition(0, 1), new TerminalSize(width, height), c);
    }

    @Override
    public void drawMainMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#2FBBEE"));
        graphics.putString(18, 5, "S  U  R  V  I  V  E", SGR.BLINK, SGR.BOLD, SGR.CROSSED_OUT, SGR.BORDERED);
        graphics.setForegroundColor(TextColor.Factory.fromString("#89D1F5"));
        graphics.putString(18, 12, "      M E N U      ", SGR.BOLD, SGR.REVERSE);
    }

    @Override
    public void drawAboutMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#B8E4F9"));
        drawAboutTexts(graphics);
    }

    @Override
    public void drawInstructionsMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#0A3F7B"));
        graphics.putString(3,3, "GAME INSTRUCTIONS:");
        graphics.setForegroundColor(TextColor.Factory.fromString("#B8E4F9"));
        drawInstructionsTexts(graphics);
    }

    @Override
    public void drawScoreMenu(String nome, HashMap<String, Integer> map){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#E28C12"));
        graphics.putString(20, 5, nome+" Scores", SGR.BOLD, SGR.BORDERED);
        graphics.putString(26, 7, "TOP 5", SGR.BOLD);
        graphics.setForegroundColor(TextColor.Factory.fromString("#B8E4F9"));

        drawScoresText(graphics, map);
    }

    @Override
    public void drawArenaScoreMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#B8E4F9"));
        graphics.putString(20, 5, "SURVIVE SCORES", SGR.BOLD, SGR.ITALIC);
        graphics.setForegroundColor(TextColor.Factory.fromString("#E28C12"));
        graphics.putString(13, 8, "WICH ARENA DO YOU WANT TO SEE?", SGR.BOLD, SGR.BORDERED);
    }

    @Override
    public void drawLoserMenu(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#052039"));
        graphics.fillRectangle(new TerminalPosition(0, 1), new TerminalSize(55, 30), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#D01111"));
        graphics.putString(15, 12, "G  A  M  E     O  V  E  R", SGR.BOLD, SGR.BORDERED);
    }

    @Override
    public void drawWinnerMenu(int score){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#052039"));
        graphics.fillRectangle(new TerminalPosition(0, 1), new TerminalSize(55, 30), ' ');
        drawWinnerTexts(graphics, score);
    }

    @Override
    public void drawArenasMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#2FBBEE"));
        graphics.putString(12, 5, "      S  U  R  V  I  V  E      ", SGR.REVERSE, SGR.BOLD, SGR.BORDERED);
        graphics.setForegroundColor(TextColor.Factory.fromString("#89D1F5"));
        graphics.putString(19, 7, "CHOOSE YOUR ARENA", SGR.BOLD, SGR.BORDERED);
    }

    @Override
    public String drawWinnerScoreMenu() {
        TextGraphics graphics = menuBackground();
        drawWinnerScoreTexts(graphics);
        return nome;
    }

    @Override
    public void drawSettingsMenu(){
        TextGraphics graphics = menuBackground();
        graphics.setForegroundColor(TextColor.Factory.fromString("#2FBBEE"));
        graphics.putString(18,6,"  S E T T I N G S  ", SGR.REVERSE);
    }

    private TextGraphics menuBackground(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#052039"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(55, 30), ' ');
        return graphics;
    }
}
