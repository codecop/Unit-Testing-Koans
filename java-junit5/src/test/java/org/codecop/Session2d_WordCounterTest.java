package org.codecop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Bonus Session 2d: WordCounterTest - Assertions with AssertJ. <br />
 * @see "https://assertj.github.io/doc/#assertj-core-quick-start"
 *
 * @author Daniel Passecker
 */
class Session2d_WordCounterTest {

    // TODO Add the proper assertions to complete the tests using AssertJ.
    // The test name explains what needs to be asserted.

    @Test
    void shouldCountNumberOfWords() {
        WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
        assertEquals(9, counter.numberOfWords());
        // AssertJ is fluent:
        // TODO Check that counter.numberOfWords(), isEqualTo 9.
    }

    @Test
    void shouldContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertTrue(Arrays.asList(counter.uniqueWords()).contains("bar"));
        // AssertJ is fluent:
        // TODO Check that counter.uniqueWords() contains "bar".
    }

    @Test
    void shouldNotContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertFalse(Arrays.asList(counter.uniqueWords()).contains("foo"));
        // AssertJ is fluent:
        // TODO Check that counter.uniqueWords() doesNotContain "foo".
    }

    @Test
    void shouldFindNumberOfUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertEquals(3, counter.uniqueWords().length);
        // AssertJ is fluent:
        // TODO Check that counter.uniqueWords() hasSize 3.
    }
}
