package org.codecop;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

/**
 * Session 5: WordCounterTableTest - parameterised/table driven. <br />
 * See https://github.com/junit-team/junit/wiki/Parameterized-tests
 */
public class Session5_WordCounterRatioTest {

    // we want to test more corner cases for the ratio, here is a table of test cases
    private static final List<Object[]> TEST_TABLE = Arrays.asList(//
            new Object[] { "green", "green", 1.0 }, //
            new Object[] { "green bar green", "green", 0.66 }, //
            new Object[] { "green bar green bar", "green", 0.5 }, //
            new Object[] { "green bar green", "bar", 0.33 } //
            );

    // TODO add the needed code/annotations to run this test with all examples

    private String sentence;
    private String word;
    private double expectedRratio;

    // TODO take data from tableData method
    public void shouldReturnRatioOfGivenWord() {
        WordCounter counter = new WordCounter(sentence);
        assertEquals(expectedRratio, counter.ratioOf(word), 0.01);
    }

}
