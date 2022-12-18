package com.project.ldts.model;

import com.project.ldts.model.game.scores.ScoreReader;
import com.project.ldts.model.game.scores.ScoreWriter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

    @Test
    public void scoreReader() throws IOException {
        ScoreReader score = new ScoreReader("Graveyard");
        assertNotEquals(score.getScores().size(), 0);

        assertNotEquals(score.sort(score.getScores()).size(), 0);

        assertFalse(score.isTop5(0));

        HashMap<String, Integer> aux = score.getScores();

        score.setTop5("Unknown", 500);
        assertNotEquals(score.getScores(), aux);
    }
}
