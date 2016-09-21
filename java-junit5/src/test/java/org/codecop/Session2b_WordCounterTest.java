package org.codecop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Session 2b: WordCounterTest - All kind of assertions. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
 */
class Session2b_WordCounterTest {

  @Test
  void shouldFindUniqueWords() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertArrayEquals(new String[]{"bar", "green", "hat"}, counter.uniqueWords());
  }

  @Test
  void shouldReturnRatioOfWords() {
    final WordCounter counter = new WordCounter("green bar green");
    assertEquals(0.33, counter.ratioOf("bar"), 0.01);
    // note that floating point numbers have accuracy delta 0.01
  }

  @Test
  void shouldReportSummaryOfWord() {
    final WordCounter counter = new WordCounter("green green");
    final WordCounter.Summary summary = counter.summaryOf("green");
    assertAll(
      () -> assertEquals("green", summary.word), //
      () -> assertEquals(2, summary.count) //
    );
    // all attributes of summary should be asserted at once
  }

  @Test
  void shouldContainUniqueWord() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertTrue(Arrays.asList(counter.uniqueWords()).contains("bar"));
    assertFalse(Arrays.asList(counter.uniqueWords()).contains("foo"));
    // optional - Hamcrest improves readability:
    assertThat(counter.uniqueWords(), hasItemInArray("bar"));
    assertThat(counter.uniqueWords(), not(hasItemInArray("foo")));
  }

  @Test
  void shouldFindNumberOfUniqueWords() {
    final WordCounter counter = new WordCounter("green bar green hat");
    assertEquals(3, counter.uniqueWords().length);
    // optional - Hamcrest improves readability:
    assertThat(counter.uniqueWords(), arrayWithSize(3));
  }
}
