package org.codecop;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Session 5: WordCounterRatioTest - parameterised/table driven tests. <br />
 * @see "https://github.com/junit-team/junit/wiki/Parameterized-tests"
 */
// TODO mark this test as parameterised
@RunWith(Parameterized.class)
public class Session5_WordCounterRatioTest {

    // TODO Add the needed annotations to run this test with all examples.

    // We want to test more corner cases for the ratio. Here is a table of test cases.
    private static final List<Object[]> TEST_CASES = Arrays.asList(//
            new Object[] { "green", "green", 1.0 }, //
            new Object[] { "green bar green", "green", 0.66 }, //
            new Object[] { "green bar green bar", "green", 0.5 }, //
            new Object[] { "green bar green", "bar", 0.33 } //
            );

    @Parameters(name = "ratio of '{1}' in words '{0}' should be {2}")
    public static List<Object[]> getTestCases() {
        return TEST_CASES;
    }

    private final String sentence;
    private final String word;
    private final double expectedRatio;

    public Session5_WordCounterRatioTest(String sentence, String word, double expectedRratio) {
        this.sentence = sentence;
        this.word = word;
        this.expectedRatio = expectedRratio;
    }

    @Test
    public void shouldReturnRatioOfGivenWord() {
        WordCounter counter = new WordCounter(sentence);
        assertEquals(expectedRatio, counter.ratioOf(word), 0.01); // keep
    }

}
