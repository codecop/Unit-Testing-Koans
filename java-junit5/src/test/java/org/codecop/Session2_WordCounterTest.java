package org.codecop;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Session 2: WordCounterTest - All kind of assertions. <br />
 * See https://github.com/junit-team/junit/wiki/Assertions
 */
class Session2_WordCounterTest {

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
  void shouldFindUniqueWords() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertArrayEquals(new String[]{"bar", "green", "hat"}, counter.uniqueWords());
  }

  @Test
  void shouldContainUniqueWord() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertTrue(Arrays.asList(counter.uniqueWords()).contains("bar"));
    assertFalse(Arrays.asList(counter.uniqueWords()).contains("foo"));
    // optional - Hamcrest can do it better
    assertThat(counter.uniqueWords(), hasItemInArray("bar"));
    assertThat(counter.uniqueWords(), not(hasItemInArray("foo")));
  }

  @Test
  void shouldFindNumberOfUniqueWords() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertEquals(3, counter.uniqueWords().length);
    // optional - Hamcrest can do it better
    assertThat(counter.uniqueWords(), arrayWithSize(3));
  }

  @Test
  void shouldReturnRatioOfWords() {
    final WordCounter counter = new WordCounter("green bar green");
    assertEquals(0.33, counter.ratioOf("bar"), 0.01);
    // note that floating point numbers have accuracy delta 0.01
  }
}
