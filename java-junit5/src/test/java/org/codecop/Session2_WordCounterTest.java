package org.codecop;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Session 3: WordCounterTest - All kind of Asserts against WordCounter.
 */
public class Session2_WordCounterTest {

    // assertEquals - just show

    @Test
    public void shouldReturnCountOfWords() {
        WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
        assertEquals(9, counter.numberOfWords());
    }

    // assertTrue - show everything but the assert line

    @Test
    public void shouldVerifyContainmentOfWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertTrue(counter.containsWord("bar"));
    }

    // assertFalse - let do themselves

    @Test
    public void shouldVerifyNonContainmentOfWord() {
        WordCounter counter = new WordCounter("green hat");
        assertFalse(counter.containsWord("red"));
    }

    // assertNull

    @Test
    public void shouldReturnNullForUnknownWordCount() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertNull(counter.countOf("else"));
    }

    // assertNotNull

    @Test
    public void shouldReturnWordCount() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertNotNull(counter.countOf("green"));
        assertEquals(Integer.valueOf(2), counter.countOf("green"));
    }

    // assertArrayEquals

    @Test
    public void shouldCountUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords());
    }

    // assertEquals(double expected, double actual, double delta) 

    @Test
    public void shouldReturnRatioOfWords() {
        WordCounter counter = new WordCounter("green bar green");
        assertEquals(0.33, counter.ratioOf("bar"), 0.01);
    }

}
