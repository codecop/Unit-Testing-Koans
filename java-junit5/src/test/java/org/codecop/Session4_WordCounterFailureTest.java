package org.codecop;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Session 5: WordCounterTest - expected and ignore.
 */
public class Session4_WordCounterFailureTest {

    // expected to test Exception, Trainer should show this one

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForUnknownWord() {
        WordCounter counter = new WordCounter("green bar green");
        counter.ratioOf("missingWord");
    }

    // now do the second one yourself 

    @Test(expected = IOException.class)
    public void shouldThrowIOExceptionOnMissingFile() throws IOException {
        new WordCounter(new File("IamSureThisDoesNotExist.txt"));
    }

    // add a test but it is not implemented yet. Let them write a test, then it does not work
    // we need to change the code, will do that tomorrow. for the time skip it

    @Test
    @Ignore("work in progress, will continue tomorrow")
    public void shouldCountUniqueWordsCaseInsensitive() {
        WordCounter counter = new WordCounter("green bar Green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords());
    }

}
