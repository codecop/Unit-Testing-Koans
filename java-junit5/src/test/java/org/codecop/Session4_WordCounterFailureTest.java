package org.codecop;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Executable;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.expectThrows;

/**
 * Session 4: WordCounterFailureTest - testing for Exceptions and ignoring tests. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
 */
class Session4_WordCounterFailureTest {

    @Test
    void shouldThrowIOExceptionOnMissingFile() {
        final Executable wordCountOfMissingFile = () -> new WordCounter(new File("IamSureThisDoesNotExist.txt"));
        assertThrows(IOException.class, wordCountOfMissingFile);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWithMessage() {
        final WordCounter counter = new WordCounter("green bar green");
        final Executable ratioOfMissingWord = () -> counter.ratioOf("missingWord");
        final IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, ratioOfMissingWord);
        assertEquals("missingWord not in sentence", exception.getMessage());
    }

    // the next test does not work, we need to change the code,
    // but we will do that tomorrow. for today ignore it

    @Test
    @Disabled("work in progress, will continue tomorrow")
    void shouldCountUniqueWordsCaseInsensitive() {
        final WordCounter counter = new WordCounter("green bar Green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords());
    }
}
