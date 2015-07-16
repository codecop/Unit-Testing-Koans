package org.codecop;

import static org.junit.Assert.assertEquals;

/**
 * Session 6 (optional): WordCounterTableTest - parameterised/table driven. <br />
 * See https://github.com/Pragmatists/junitparams
 */
public class Session6_WordCounterRatioAlternativeTest {

    // we want to test more corner cases for the ratio, here is a table of test cases
    // TODO use JUnitParams to run with these parameters
//        "green, green, 1.0", //
//        "green bar green, green, 0.66", //
//        "green bar green bar, green, 0.5", //
//        "green bar green, bar, 0.33" //

    public void shouldReturnRatioOfGivenWord(String sentence, String word, double expectedRratio) {
        WordCounter counter = new WordCounter(sentence);
        assertEquals(expectedRratio, counter.ratioOf(word), 0.01);
    }

}
