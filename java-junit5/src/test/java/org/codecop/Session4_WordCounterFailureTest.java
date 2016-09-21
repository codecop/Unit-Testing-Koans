package org.codecop;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Executable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.expectThrows;

/**
 * Session 4: WordCounterFailureTest - testing for Exceptions and ignoring tests. <br />
 * See https://github.com/junit-team/junit/wiki/Exception-testing
 */
class Session4_WordCounterFailureTest {

  @Test
  void shouldThrowIllegalArgumentExceptionForUnknownWord() {
    final WordCounter counter = new WordCounter("green bar green");
    final Executable ratioOfMissingWord = () -> counter.ratioOf("missingWord");
    expectThrows(IllegalArgumentException.class, ratioOfMissingWord);
  }

  @Test
  void shouldThrowIOExceptionOnMissingFile() {
    final Executable wordCountOfMissingFile = () -> new WordCounter(new File("IamSureThisDoesNotExist.txt"));
    expectThrows(IOException.class, wordCountOfMissingFile);
  }

  // TODO verify exception message

  // the next test does not work, we need to change the code,
  // but we will do that tomorrow. for today ignore it

  @Test
  @Disabled("work in progress, will continue tomorrow")
  void shouldCountUniqueWordsCaseInsensitive() {
    final WordCounter counter = new WordCounter("green bar Green hat");
    assertArrayEquals(new String[]{"bar", "green", "hat"}, counter.uniqueWords());
  }
}
