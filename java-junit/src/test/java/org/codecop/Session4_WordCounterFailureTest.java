package org.codecop;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.CatchException.verifyException;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Session 4: WordCounterFailureTest - testing for Exceptions and ignoring tests. <br />
 * See https://github.com/junit-team/junit/wiki/Exception-testing
 */
public class Session4_WordCounterFailureTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForUnknownWord() {
        WordCounter counter = new WordCounter("green bar green");
        counter.ratioOf("missingWord");
    }

    /**
     * optional - catchException can do it better. <br />
     * See https://github.com/Codearte/catch-exception
     */
    @Test
    public void shouldThrowInvalidArgumentExceptionAlternative() {
        WordCounter counter = new WordCounter("green bar green");
        verifyException(counter, IllegalArgumentException.class).ratioOf("anotherMissingWord");

        // optional - Hamcrest can do it better
        catchException(counter).ratioOf("anotherMissingWord");
        assertThat(caughtException(), IsInstanceOf.instanceOf(IllegalArgumentException.class));
    }

    @Test(expected = IOException.class)
    public void shouldThrowIOExceptionOnMissingFile() throws IOException {
        new WordCounter(new File("IamSureThisDoesNotExist.txt"));
    }

    // the next test does not work, we need to change the code,
    // but we will do that tomorrow. for today ignore it

    @Test
    @Ignore("work in progress, will continue tomorrow")
    public void shouldCountUniqueWordsCaseInsensitive() {
        WordCounter counter = new WordCounter("green bar Green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords());
    }

}
