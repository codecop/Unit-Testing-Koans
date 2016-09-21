package org.codecop;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToFileTest {

  private final File testFile = new File("StringToFileTest.tmp");

  @After
  public void deleteTestFile() {
    testFile.delete();
  }

  @Test
  public void shouldWriteAndRead() throws IOException {
    final String original = "Keep the bar green to keep the code clean.";
    StringToFile.write(original, testFile);
    assertEquals(original, StringToFile.read(testFile));
  }
}
