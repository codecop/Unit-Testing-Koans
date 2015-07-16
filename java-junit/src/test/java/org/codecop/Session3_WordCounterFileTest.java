package org.codecop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Session 3: WordCounterFileTest - Fixtures, e.g. using a test file. <br />
 * See https://github.com/junit-team/junit/wiki/Test-fixtures
 */
public class Session3_WordCounterFileTest {

    @Test
    public void shouldReturnCountOfWords() throws IOException {
        File file = new File("tmp");
        StringToFile.write("Keep the bar green to keep the code clean.", file);

        WordCounter counter = new WordCounter(file);
        assertEquals(9, counter.numberOfWords());

        file.delete();
    }

    // the problem is that delete is not called in case of test failure,
    // better use Before/After hooks for test file handling

    private final File testFile = new File("FileWordCounterTest.tmp");

    @Before
    public void createFreshTestFileForEachTest() throws IOException {
        StringToFile.write("Keep the bar green to keep the code clean.", testFile);
    }

    @After
    public void deleteTestFile() {
        assertTrue(testFile.delete());
    }

    @Test
    public void shouldReturnCountOfWordsBetter() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        assertEquals(9, counter.numberOfWords());
    }

    @Test
    public void shouldVerifyContainmentOfWord() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        assertTrue(counter.containsWord("bar"));
    }
}
