package org.codecop;

import org.junit.Test;

/**
 * Session 1: GreeterTest - Your first tests.
 */
public class Session1_GreeterTest {

    // TODO we will add the proper assertions together

    @Test
    public void shouldReturnHelloName() {
        Greeter greeter = new Greeter();
        // TODO check that "Hello Peter", greeter.greet("Peter")
    }

    @Test
    public void shouldReturnHelloForNull() {
        Greeter greeter = new Greeter();
        // TODO check that "Hello", greeter.greet(null)
    }

    @Test
    public void shouldIgnoreWhitespace() {
        Greeter greeter = new Greeter();
        // TODO check that "Hello Peter", greeter.greet(" Peter ")
    }

}
