package org.codecop;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Session 2a: WordCounterTest - Basic assertions. <br />
 * @see "https://github.com/junit-team/junit/wiki/Assertions"
 */
public class Session2a_WordCounterTest {

    // TODO Add the proper assertions to complete the tests. 
    // The test name explains what needs to be asserted. 
    
    @Test
    public void shouldCountNumberOfWords() {
        WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
        // TODO Check that 9, counter.numberOfWords().
    }

    @Test
    public void shouldVerifyContainmentOfWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO Check that counter.containsWord("bar").
    }

    @Test
    public void shouldVerifyNonContainmentOfWord() {
        WordCounter counter = new WordCounter("green hat");
        // TODO Check that counter.containsWord("red") is false.
    }

    @Test
    public void shouldReturnNullForUnknownWordCount() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO Check that counter.countOf("else") is null.
    }

    @Test
    public void shouldReturnNotNullWordCountForExistingWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO Check that counter.countOf("green") is not null.
    }

    @Test
    public void shouldCountGreenTwice() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO Check that 2, counter.countOf("green").
    }

    @Test
    public void shouldFindUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO Check that new String[] { "bar", "green", "hat" }, counter.uniqueWords().
    }

    @Test
    public void shouldReturnRatioOfWords() {
        WordCounter counter = new WordCounter("green bar green");
        // TODO Check that 0.33, counter.ratioOf("bar").
        // Note that floating point numbers need an accuracy delta, e.g. 0.01.
    }

}
