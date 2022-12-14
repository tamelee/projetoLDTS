package com.project.ldts.model.game.scores;

import java.io.*;
import java.util.*;

public class ScoreReader {
    private final String fileName;
    private HashMap<String, Integer> scores;

    public ScoreReader(String fileName) throws IOException {
        this.fileName = fileName;
        scores = new HashMap<>();
        read();
    }

    public HashMap<String, Integer> getScores() {
        return scores;
    }

    public void read() throws IOException {
        FileReader file = new FileReader("docs/scores/" +fileName+ ".txt");
        BufferedReader br = new BufferedReader(file);

        String line;

        while ((line = br.readLine()) != null) {

            String[] parts = line.split(":");

            if(!parts[0].trim().equals("") && !parts[1].trim().equals("")) {
                String name = parts[0].trim();
                Integer number = Integer.parseInt(parts[1].trim());

                scores.put(name, number);
            }
        }

        br.close();
    }

    public HashMap<String, Integer> sort(HashMap<String, Integer> map){
        List<Map.Entry<String, Integer> > list = new LinkedList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aux : list) {
            temp.put(aux.getKey(), aux.getValue());
        }
        return temp;
    }

    public boolean isTop5(int score){
        List<Map.Entry<String, Integer> > list = new LinkedList<>(scores.entrySet());
        if(list.isEmpty())
            return true;
        for (Map.Entry<String, Integer> aux : list) {
            if(score > aux.getValue()){
                return true;
            }
        }
        return false;
    }

    public void setTop5(String name, int score){
        scores.put(name, score);
        scores = sort(scores);
        List<Map.Entry<String, Integer> > list = new LinkedList<>(scores.entrySet());
        list.remove(list.size()-1);
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aux : list) {
            temp.put(aux.getKey(), aux.getValue());
        }
        scores = temp;
    }
}
