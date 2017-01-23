package org.codecop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Session 2b: WordCounterTest - Assertions new in JUnit 5. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
 */
class Session2b_WordCounterTest {

    // TODO Add the proper assertions to complete the tests. 
    // The test name explains what needs to be asserted. 

    @Test
    void shouldCountGreenTwice() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertEquals(Integer.valueOf(2), counter.countOf("green"));
    }

    @Test
    void shouldNotCountCapitalizedWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertNotEquals(1, counter.countOf("HAT"));
    }

    @Test
    void shouldFindUniqueWordAsSequence() {
        WordCounter counter = new WordCounter("green green");
        assertIterableEquals(Arrays.asList("green"), counter.uniqueWordsAsSequence());
    }
    
    @Test
    void shouldReportSummaryOfWord() {
        WordCounter counter = new WordCounter("green green");
        WordCounter.Summary summary = counter.summaryOf("green");
        // TODO All these attributes of summary should be asserted at once.
        assertAll( // drop
                () -> assertEquals("green", summary.word), //
                () -> assertEquals(2, summary.count) //
        ); // drop
    }

    @Test
    void shouldCountNumberOfWorldsIn100Millis() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertTimeout(Duration.ofMillis(200), counter::numberOfWords);
    }
    
}
