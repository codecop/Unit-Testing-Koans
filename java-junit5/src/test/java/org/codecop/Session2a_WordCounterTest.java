package org.codecop;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Session 2a: WordCounterTest - Basic assertions. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
 */
class Session2a_WordCounterTest {

    @Test
    void shouldCountNumberOfWords() {
        WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
        assertEquals(9, counter.numberOfWords());
    }

    @Test
    void shouldVerifyContainmentOfWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertTrue(counter.containsWord("bar"));
    }

    @Test
    void shouldVerifyNonContainmentOfWord() {
        WordCounter counter = new WordCounter("green hat");
        assertFalse(counter.containsWord("red"));
    }

    @Test
    void shouldReturnNullForUnknownWordCount() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertNull(counter.countOf("else"));
    }

    @Test
    void shouldReturnNotNullWordCountForExistingWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertNotNull(counter.countOf("green"));
    }

    @Test
    void shouldFindUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords());
    }

    @Test
    void shouldReturnRatioOfWords() {
        WordCounter counter = new WordCounter("green bar green");
        assertEquals(0.33, counter.ratioOf("bar"), 0.01);
        // note that floating point numbers have accuracy delta 0.01
    }
}
