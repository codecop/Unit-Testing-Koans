package org.codecop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Bonus Session 2d: WordCounterTest - Assertions with AssertJ. <br />
 * @see "http://joel-costigliola.github.io/assertj/assertj-core-quick-start.html"
 * 
 * @author Daniel Passecker
 */
class Session2d_WordCounterTest {

    // TODO Add the proper assertions to complete the tests using AssertJ. 
    // The test name explains what needs to be asserted. 

    @Test
    void shouldContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertTrue(Arrays.asList(counter.uniqueWords()).contains("bar")); 
        assertFalse(Arrays.asList(counter.uniqueWords()).contains("foo")); 
        // AssertJ improves readability:
        // TODO Check that counter.uniqueWords() contains "bar".
        // TODO Check that counter.uniqueWords() doesNotContain "foo".
    }

    @Test
    void shouldFindNumberOfUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertEquals(3, counter.uniqueWords().length); 
        // AssertJ improves readability:
        // TODO Check that counter.uniqueWords() hasSize 3.
    }
}
