package org.codecop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Session 1: GreeterTest - Your first tests.
 */
public class Session1_GreeterTest {

    // TODO We will add the proper assertions together.

    @Test
    public void shouldReturnHelloName() {
        Greeter greeter = new Greeter();
        // TODO Check that "Hello Peter", greeter.greet("Peter").
    }

    @Test
    public void shouldReturnHelloForNull() {
        Greeter greeter = new Greeter();
        // TODO Check that "Hello", greeter.greet(null).
    }

    @Test
    public void shouldIgnoreWhitespace() {
        Greeter greeter = new Greeter();
        // TODO Check that "Hello Peter", greeter.greet(" Peter ").
    }

}
