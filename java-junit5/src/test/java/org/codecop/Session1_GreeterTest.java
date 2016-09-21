package org.codecop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Session 1: GreeterTest - Your first tests.
 */
class Session1_GreeterTest {

    @Test
    void shouldReturnHelloName() {
        final Greeter greeter = new Greeter();
        assertEquals("Hello Peter", greeter.greet("Peter"));
    }

    @Test
    @DisplayName("should return 'Hello' for 'null'")
    void shouldReturnHelloForNull() {
        final Greeter greeter = new Greeter();
        assertEquals("Hello", greeter.greet(null));
    }

    @Test
    void shouldIgnoreWhitespace() {
        final Greeter greeter = new Greeter();
        assertEquals("Hello Peter", greeter.greet(" Peter "));
    }
}
