package org.codecop;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Session 6: WordCounterTableTest - parameterised/table driven.
 */
@RunWith(Parameterized.class)
public class Session5_WordCounterRatioTest {

    // want to test more corner cases for ratio, have a table of test cases
    private static final List<Object[]> TEST_TABLE = Arrays.asList(//
            // instructor shows this table data in slides
            new Object[] { "green", "green", 1.0 }, //
            new Object[] { "green bar green", "green", 0.66 }, //
            new Object[] { "green bar green bar", "green", 0.5 }, //
            new Object[] { "green bar green", "bar", 0.33 } //
            );

    @Parameters
    public static List<Object[]> tableData() {
        return TEST_TABLE;
    }

    private String sentence;
    private String word;
    private double expectedRratio;

    public Session5_WordCounterRatioTest(String sentence, String word, double expectedRratio) {
        this.sentence = sentence;
        this.word = word;
        this.expectedRratio = expectedRratio;
    }

    @Test
    public void shouldReturnRatioOfGivenWord() {
        WordCounter counter = new WordCounter(sentence);
        assertEquals(expectedRratio, counter.ratioOf(word), 0.01);
    }
}
