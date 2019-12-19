package org.codecop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.ArrayMatching.hasItemInArray;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Bonus Session 2c: WordCounterTest - Assertions with Hamcrest. <br />
 * @see "http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/package-summary.html"
 */
class Session2c_WordCounterTest {

    // TODO Add the proper assertions to complete the tests using Hamcrest.
    // The test name explains what needs to be asserted.

    @Test
    void shouldCountNumberOfWords() {
        WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
        assertEquals(9, counter.numberOfWords()); // keep
        // Hamcrest improves readability:
        assertThat(counter.numberOfWords(), equalTo(9));
    }

    @Test
    void shouldContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertTrue(Arrays.asList(counter.uniqueWords()).contains("bar")); // keep
        // Hamcrest improves readability:
        assertThat(counter.uniqueWords(), hasItemInArray("bar"));
    }

    @Test
    void shouldNotContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertFalse(Arrays.asList(counter.uniqueWords()).contains("foo")); // keep
        // Hamcrest improves readability:
        assertThat(counter.uniqueWords(), not(hasItemInArray("foo")));
    }

    @Test
    void shouldFindNumberOfUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertEquals(3, counter.uniqueWords().length); // keep
        // Hamcrest improves readability:
        assertThat(counter.uniqueWords(), arrayWithSize(3));
    }
}
