package org.codecop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Session 2a: WordCounterTest - Basic assertions. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
 */
class Session2a_WordCounterTest {

  @Test
  void shouldCountNumberOfWords() {
    final WordCounter counter = new WordCounter("Keep the bar green to keep the code clean.");
    assertEquals(9, counter.numberOfWords());
  }

  @Test
  void shouldVerifyContainmentOfWord() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertTrue(counter.containsWord("bar"));
  }

  @Test
  void shouldVerifyNonContainmentOfWord() {
    final WordCounter counter = new WordCounter("green hat");
    assertFalse(counter.containsWord("red"));
  }

  @Test
  void shouldReturnNullForUnknownWordCount() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertNull(counter.countOf("else"));
  }

  @Test
  void shouldReturnNotNullWordCountForExistingWord() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertNotNull(counter.countOf("green"));
  }

  @Test
  void shouldCountGreenTwice() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertEquals(Integer.valueOf(2), counter.countOf("green"));
  }

  @Test
  void shouldNotCountCapitalizedWord() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertNotEquals(1, counter.countOf("HAT"));
  }
}
