package org.codecop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * Session 2b: WordCounterTest - Assertions new in JUnit 5. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
 */
class Session2b_WordCounterTest {

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
    void shouldReportSummaryOfWord() {
        WordCounter counter = new WordCounter("green green");
        WordCounter.Summary summary = counter.summaryOf("green");
        assertAll( //
                () -> assertEquals("green", summary.word), //
                () -> assertEquals(2, summary.count) //
        );
        // all attributes of summary should be asserted at once
    }
}
