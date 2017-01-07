package org.codecop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.codecop.TempFile.Temp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Session 6: WordCounterFileExtensionTest - Reuse fixtures in Extensions. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#extensions
 */
@ExtendWith(TempFile.class)
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
