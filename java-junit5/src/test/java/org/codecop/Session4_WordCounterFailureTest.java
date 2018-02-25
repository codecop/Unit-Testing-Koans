package org.codecop;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;

/**
 * Session 4: WordCounterFailureTest - Exceptions and ignoring tests. <br />
 * @see "http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions"
 */
class Session4_WordCounterFailureTest {

    // TODO Add the needed code/annotations to test for an expected exception.
    
    @Test
    void shouldThrowIOExceptionOnMissingFile() {
        Executable wordCountOfMissingFile = () -> new WordCounter(new File("IamSureThisDoesNotExist.txt"));
        assertThrows(IOException.class, wordCountOfMissingFile);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWithMessage() {
        WordCounter counter = new WordCounter("green bar green");
        Executable ratioOfMissingWord = () -> counter.ratioOf("missingWord");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ratioOfMissingWord);
        assertEquals("missingWord not in sentence", exception.getMessage());
    }

    // TODO The next test does not work, we need to change the code,
    // but we will do that tomorrow. For today let's ignore it.

    @Test
    @Disabled("work in progress, will continue tomorrow")
    void shouldCountUniqueWordsCaseInsensitive() {
        WordCounter counter = new WordCounter("green bar Green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords()); // keep
    }
}
