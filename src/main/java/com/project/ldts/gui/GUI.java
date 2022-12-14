package com.project.ldts.gui;

import com.project.ldts.model.Position;

import java.io.IOException;
import java.util.HashMap;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayer(Position position);
    void drawOnWater(Position position, char c);
    void drawOnSand(Position position, char c, String color);
    void drawWall(Position position);
    void drawEnemy(Position position);
    void drawWater(Position position);
    void drawSand(Position position);
    void drawSafeHouse(Position position);
    void drawSpecialBox(Position position);
    void drawBullet(Position position);
    void drawText(Position position, String text, String color);
    void drawFirstRow(int health, String minutes, char power, String seconds, int enemies);
    void drawArenaFloor(int width, int height, char c);
    void drawMainMenu();
    void drawAboutMenu();
    void drawInstructionsMenu();
    void drawScoreMenu(String name, HashMap<String, Integer> map);
    void drawArenaScoreMenu();
    void drawLoserMenu();
    void drawWinnerMenu(int score);
    void drawArenasMenu();
    String drawWinnerScoreMenu();
    void drawSettingsMenu();
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SHOT, COLLECT}
}