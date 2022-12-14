package com.project.ldts.model.game.arena;

import com.project.ldts.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArenaLoader extends ArenaBuilder{
    private final List<String> lines;

    public ArenaLoader(String fileName) throws IOException {
        URL resource = getClass().getClassLoader().getResource("arenas/"+fileName + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    public int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }


    public int getHeight() {
        return lines.size();
    }


    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '1') walls.add(new Wall(x, y));
        }

        return walls;
    }


    protected List<Enemy> createEnemies() {
        List<Enemy> monsters = new CopyOnWriteArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '5') monsters.add(new Enemy(x, y));
        }

        return monsters;
    }


    protected Player createPlayer() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '4') return new Player(x, y);
        }
        return null;
    }

    protected List<Water> createWater() {
        List<Water> waters = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '3') waters.add(new Water(x, y));
        }

        return waters;
    }

    protected List<Sand> createSand() {
        List<Sand> sands = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '2') sands.add(new Sand(x, y));
        }

        return sands;
    }

    protected List<SafeHouse> createSafeHouse() {
        List<SafeHouse> shs = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '6') shs.add(new SafeHouse(x, y));
        }

        return shs;
    }

    protected List<SpecialBox> createSpecialBox() {
        List<SpecialBox> sb = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '7') sb.add(new SpecialBox(x, y));
        }

        return sb;
    }
}
