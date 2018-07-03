package org.codecop;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Session 5: WordCounterTableTest - parameterised/table driven. <br />
 * See https://github.com/junit-team/junit/wiki/Parameterized-tests
 */
@RunWith(Parameterized.class)
public class Session5_WordCounterRatioTest {

    // we want to test more corner cases for the ratio, here is a table of test cases
    private static final List<Object[]> TEST_TABLE = Arrays.asList(//
            new Object[] { "green", "green", 1.0 }, //
            new Object[] { "green bar green", "green", 0.66 }, //
            new Object[] { "green bar green bar", "green", 0.5 }, //
            new Object[] { "green bar green", "bar", 0.33 } //
            );

    @Parameters(name = "ratio of '{1}' in words '{0}' should be {2}")
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
