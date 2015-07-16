package org.codecop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Session 1: GreeterTest - Your first tests.
 */
public class Session1_GreeterTest {

    @Test
    public void shouldReturnHelloName() {
        Greeter greeter = new Greeter();
        assertEquals("Hello Peter", greeter.greet("Peter"));
    }

    @Test
    public void shouldReturnHelloForNull() {
        Greeter greeter = new Greeter();
        assertEquals("Hello", greeter.greet(null));
    }

    @Test
    public void shouldIgnoreWhitespace() {
        Greeter greeter = new Greeter();
        assertEquals("Hello Peter", greeter.greet(" Peter "));
    }

}
