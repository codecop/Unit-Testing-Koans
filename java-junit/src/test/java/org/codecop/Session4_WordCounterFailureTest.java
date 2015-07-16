package org.codecop;

import static com.googlecode.catchexception.CatchException.catchException;
import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Session 4: WordCounterFailureTest - testing for Exceptions and ignoring tests. <br />
 * See https://github.com/junit-team/junit/wiki/Exception-testing
 */
public class Session4_WordCounterFailureTest {

    // TODO add the needed code/annotations to test for an expected exception, then
    // TODO enable the tests to complete them

    // TODO expect InvalidArgumentException
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
        // TODO use verifyException to check that IllegalArgumentException.class is thrown by ratioOf("anotherMissingWord")

        // optional - Hamcrest can do it better
        catchException(counter).ratioOf("anotherMissingWord");
        // TODO check that caughtException() is IllegalArgumentException.class
    }

    // TODO expect IOException.class
    public void shouldThrowIOExceptionOnMissingFile() throws IOException {
        new WordCounter(new File("IamSureThisDoesNotExist.txt"));
    }

    // the next test does not work, we need to change the code,
    // but we will do that tomorrow. for today ignore it

    @Test
    // TODO mark test as ignored with "work in progress, will continue tomorrow"
    public void shouldCountUniqueWordsCaseInsensitive() {
        WordCounter counter = new WordCounter("green bar Green hat");
        assertArrayEquals(new String[] { "bar", "green", "hat" }, counter.uniqueWords());
    }

}
