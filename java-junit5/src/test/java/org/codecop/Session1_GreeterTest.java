package org.codecop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Session 1: GreeterTest - Your first tests.
 */
class Session1_GreeterTest {

    @Test
    void shouldReturnHelloName() {
        Greeter greeter = new Greeter();
        assertEquals("Hello Peter", greeter.greet("Peter"));
    }

    @Test
    @DisplayName("should return 'Hello' for 'null'")
    void shouldReturnHelloForNull() {
        Greeter greeter = new Greeter();
        assertEquals("Hello", greeter.greet(null));
    }

    @Test
    void shouldIgnoreWhitespace() {
        Greeter greeter = new Greeter();
        assertEquals("Hello Peter", greeter.greet(" Peter "));
    }
}
