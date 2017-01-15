package org.codecop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Bonus Session 2c: WordCounterTest - Assertions with Hamcrest. <br />
 * See http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/package-summary.html
 */
class Session2c_WordCounterTest {

    // TODO Add the proper assertions to complete the tests. 
    // The test name explains what needs to be asserted. 
    
    @Test
    void shouldContainUniqueWord() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertTrue(Arrays.asList(counter.uniqueWords()).contains("bar")); 
        assertFalse(Arrays.asList(counter.uniqueWords()).contains("foo")); 
        // Hamcrest improves readability:
        // TODO Check that counter.uniqueWords(), hasItemInArray("bar").
        // TODO Check that counter.uniqueWords(), not(hasItemInArray("foo")).
    }

    @Test
    void shouldFindNumberOfUniqueWords() {
        WordCounter counter = new WordCounter("green bar green hat");
        assertEquals(3, counter.uniqueWords().length); 
        // Hamcrest improves readability:
        // TODO Check that counter.uniqueWords(), arrayWithSize(3).
    }
}
