package org.codecop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * Session 5: WordCounterTableTest - parameterised/table driven. <br />
 * See https://github.com/junit-team/junit/wiki/Parameterized-tests
 */
class Session5_WordCounterRatioTest {

  @Test
  public void convinceIntelliJThatThisIsAValidJUnit5Test() {
  }

  // we want to test more corner cases for the ratio, here is a table of test cases
  private static final List<TestCase> TEST_TABLE = Arrays.asList(//
    new TestCase("green", "green", 1.0), //
    new TestCase("green bar green", "green", 0.66), //
    new TestCase("green bar green bar", "green", 0.5), //
    new TestCase("green bar green", "bar", 0.33) //
  );

  static class TestCase {

    private final String sentence;
    private final String word;
    private final double expectedRatio;

    TestCase(final String sentence, final String word, final double expectedRatio) {
      this.sentence = sentence;
      this.word = word;
      this.expectedRatio = expectedRatio;
    }

    void shouldReturnRatioOfGivenWord() {
      final WordCounter counter = new WordCounter(sentence);
      assertEquals(expectedRatio, counter.ratioOf(word), 0.01);
    }

    String name() {
      return String.format("ratio of '%s' in words '%s' should be %s", word, sentence, expectedRatio);
    }
  }

  @TestFactory
  List<DynamicTest> createTests() {
    return TEST_TABLE.stream()
      .map(testCase -> dynamicTest(testCase.name(), testCase::shouldReturnRatioOfGivenWord))
      .collect(Collectors.toList());
  }
}
