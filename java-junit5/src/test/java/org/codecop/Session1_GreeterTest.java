package org.codecop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Session 1: GreeterTest - Your first tests.
 */
public class Session1_GreeterTest {

  @Test
  public void shouldReturnHelloName() {
    final Greeter greeter = new Greeter();
    assertEquals("Hello Peter", greeter.greet("Peter"));
  }

  @Test
  public void shouldReturnHelloForNull() {
    final Greeter greeter = new Greeter();
    assertEquals("Hello", greeter.greet(null));
  }

  @Test
  public void shouldIgnoreWhitespace() {
    final Greeter greeter = new Greeter();
    assertEquals("Hello Peter", greeter.greet(" Peter "));
  }
}
