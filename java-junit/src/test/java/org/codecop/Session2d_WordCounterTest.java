package org.codecop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Bonus Session 2d: WordCounterTest - Assertions with AssertJ. <br />
 * @see "http://joel-costigliola.github.io/assertj/assertj-core-quick-start.html"
 * 
 * @author Daniel Passecker
 */
public class Session2d_WordCounterTest {

    // TODO Add the proper assertions to complete the tests using AssertJ.
    // The test name explains what needs to be asserted.

    @Test
    public void shouldCountNumberOfWords() {
        WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
        assertEquals(9, counter.numberOfWords()); // keep
        // AssertJ is fluent:
        assertThat(counter.numberOfWords()).isEqualTo(9);
    }

    @Test
    public void shouldContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertTrue(Arrays.asList(counter.uniqueWords()).contains("bar")); // keep
        // AssertJ is fluent:
        assertThat(counter.uniqueWords()).contains("bar");
    }

    @Test
    public void shouldNotContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertFalse(Arrays.asList(counter.uniqueWords()).contains("foo")); // keep
        // AssertJ is fluent:
        assertThat(counter.uniqueWords()).doesNotContain("foo");
    }

    @Test
    public void shouldFindNumberOfUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertEquals(3, counter.uniqueWords().length); // keep
        // AssertJ is fluent:
        assertThat(counter.uniqueWords()).hasSize(3);
    }
}
