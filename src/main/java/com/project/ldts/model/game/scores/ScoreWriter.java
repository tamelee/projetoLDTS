package com.project.ldts.model.game.scores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScoreWriter {
    private final String fileName;
    private final HashMap<String, Integer> scores;

    public ScoreWriter(String fileName, HashMap<String, Integer> scores) throws IOException {
        this.fileName = fileName;
        this.scores = scores;
        write();
    }

    public void write() throws IOException {
        FileWriter file = new FileWriter("docs/scores/" +fileName+ ".txt");

        try (BufferedWriter bw = new BufferedWriter(file)) {
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
