package org.codecop;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.CatchException.verifyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

/**
 * Bonus Session 4b: WordCounterFailureTest - Exceptions with catchException. <br />
 * @see "https://github.com/Codearte/catch-exception"
 */
public class Session4b_WordCounterFailureTest {

    // TODO Add the needed code/annotations to test for an expected exception.
    
    @Test
    public void shouldThrowIllegalArgumentExceptionWithMessageOnUnknownWord() {
        WordCounter counter = new WordCounter("green bar green");
        verifyException(counter, IllegalArgumentException.class).ratioOf("missingWord");

        // Hamcrest improves readability:
        catchException(counter).ratioOf("missingWord");
        assertThat(caughtException(), IsInstanceOf.instanceOf(IllegalArgumentException.class));
        assertEquals("missingWord not in sentence", caughtException().getMessage());
    }

}
