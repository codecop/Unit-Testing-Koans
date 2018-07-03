package org.codecop;

import static org.junit.Assert.assertEquals;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Session 5b: WordCounterRatioTest - parameterised/table driven tests with JUnitParams. <br />
 * @see "https://github.com/Pragmatists/junitparams"
 */
@RunWith(JUnitParamsRunner.class) // Mark this test as parameterised with JUnitParams
public class Session5b_WordCounterRatioTest {

    // TODO Add the needed annotations to run this test with all examples.
    
    @Test // keep
    // We want to test more cases for the ratio. Here is a table of test cases.
    @Parameters(// // drop
        // use /*
        {
        "green, green, 1.0", //
        "green bar green, green, 0.66", //
        "green bar green bar, green, 0.5", //
        "green bar green, bar, 0.33" //
        }
        // use */
    ) // drop
    public void shouldReturnRatioOfGivenWord(String sentence, String word, double expectedRatio) {
        WordCounter counter = new WordCounter(sentence);
        assertEquals(expectedRatio, counter.ratioOf(word), 0.01); // keep
    }

}
