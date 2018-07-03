package org.codecop;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Session 4: WordCounterFailureTest - Exceptions and ignoring tests. <br />
 * @see "https://github.com/junit-team/junit/wiki/Exception-testing"
 */
public class Session4_WordCounterFailureTest {

    // TODO Add the needed code/annotations to test for an expected exception.

    // TODO Mark this test to expect IOException.class.
    public void shouldThrowIOExceptionOnMissingFile() throws IOException {
        new WordCounter(new File("IamSureThisDoesNotExist.txt"));
    }

    // TODO Mark this test to expect IllegalArgumentException.class.
    public void shouldThrowIllegalArgumentExceptionForUnknownWord() {
        WordCounter counter = new WordCounter("green bar green");
        counter.ratioOf("missingWord");
    }

    // TODO The next test does not work, we need to change the code,
    // but we will do that tomorrow. For today let's ignore it.

    @Test
    // TODO Mark this test as ignored with "work in progress, will continue tomorrow".
    public void shouldCountUniqueWordsCaseInsensitive() {
        WordCounter counter = new WordCounter("green bar Green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords()); 
    }

}
