package org.codecop;

import org.junit.Test;

/**
 * Session 2: WordCounterTest - All kind of assertions. <br />
 * See https://github.com/junit-team/junit/wiki/Assertions
 */
public class Session2_WordCounterTest {

    // TODO add the proper assertions to complete the tests, 
    // the test name explains what needs to be verified 

    @Test
    public void shouldCountNumberOfWords() {
        WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
        // TODO check that 9, counter.numberOfWords()
    }

    @Test
    public void shouldVerifyContainmentOfWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO check that counter.containsWord("bar")
    }

    @Test
    public void shouldVerifyNonContainmentOfWord() {
        WordCounter counter = new WordCounter("green hat");
        // TODO check that counter.containsWord("red")
    }

    @Test
    public void shouldReturnNullForUnknownWordCount() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO check that counter.countOf("else") is null
    }

    @Test
    public void shouldReturnNotNullWordCountForExistingWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO check that counter.countOf("green") is not null
    }

    @Test
    public void shouldCountGreenTwice() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO check that 2, counter.countOf("green")
    }

    @Test
    public void shouldFindUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO check that  "bar", "green", "hat", counter.uniqueWords()
    }

    @Test
    public void shouldContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO check that counter.uniqueWords() contains("bar")
        // TODO check that counter.uniqueWords() not contains("foo")
        // optional - Hamcrest can do it better
        // TODO check that counter.uniqueWords(), hasItemInArray("bar")
        // TODO check that counter.uniqueWords(), not hasItemInArray("foo")
    }

    @Test
    public void shouldFindNumberOfUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        // TODO check that 3, counter.uniqueWords() len
        // optional - Hamcrest can do it better
        // TODO check that counter.uniqueWords(), arrayWithSize 3
    }

    @Test
    public void shouldReturnRatioOfWords() {
        WordCounter counter = new WordCounter("green bar green");
        // TODO check that 0.33, counter.ratioOf("bar")
        // note that floating point numbers have accuracy delta 0.01
    }

}
