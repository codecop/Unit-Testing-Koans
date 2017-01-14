package org.codecop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.codecop.Session6_TempFile.Temp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Session 6: WordCounterFileExtensionTest - Reuse fixtures in Extensions. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#extensions
 */
@ExtendWith(Session6_TempFile.class) // Use the TempFile extension to create a temporary words file for each test. 
class Session6_WordCounterFileExtensionTest {

    @Test
    void shouldReturnCountOfWordsBetter(@Temp File wordsFile) throws IOException {
        WordCounter counter = new WordCounter(wordsFile);
        assertEquals(9, counter.numberOfWords()); // keep
    }

    @Test
    void shouldVerifyContainmentOfWord(@Temp File wordsFile) throws IOException {
        WordCounter counter = new WordCounter(wordsFile);
        assertTrue(counter.containsWord("bar")); // keep
    }
}
