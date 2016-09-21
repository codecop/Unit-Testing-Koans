package org.codecop;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Session 5: WordCounterTableTest - parameterised/table driven. <br />
 * See https://github.com/junit-team/junit/wiki/Parameterized-tests
 */
@RunWith(Parameterized.class)
class Session5_WordCounterRatioTest {

  // we want to test more corner cases for the ratio, here is a table of test cases
  private static final List<Object[]> TEST_TABLE = Arrays.asList(//
    new Object[]{"green", "green", 1.0}, //
    new Object[]{"green bar green", "green", 0.66}, //
    new Object[]{"green bar green bar", "green", 0.5}, //
    new Object[]{"green bar green", "bar", 0.33} //
  );

  @Parameters(name = "ratio of '{1}' in words '{0}' should be {2}")
  static List<Object[]> tableData() {
    return TEST_TABLE;
  }

  private final String sentence;
  private final String word;
  private final double expectedRratio;

  Session5_WordCounterRatioTest(final String sentence, final String word, final double expectedRratio) {
    this.sentence = sentence;
    this.word = word;
    this.expectedRratio = expectedRratio;
  }

  @Test
  void shouldReturnRatioOfGivenWord() {
    final WordCounter counter = new WordCounter(sentence);
    assertEquals(expectedRratio, counter.ratioOf(word), 0.01);
  }
}
