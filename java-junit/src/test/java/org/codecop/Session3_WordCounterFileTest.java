package org.codecop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

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
    // TODO add the needed annotations to the hook methods and then
    // TODO add the proper assertions to complete the tests

    private final File testFile = new File("FileWordCounterTest.tmp");

    // TODO this needs to be called before each test
    public void createFreshTestFileForEachTest() throws IOException {
        StringToFile.write("Keep the bar green to keep the code clean.", testFile);
    }

    // TODO this needs to be called after each test
    public void deleteTestFile() {
        assertTrue(testFile.delete());
    }

    @Test
    public void shouldReturnCountOfWordsBetter() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        // TODO check that 9, counter.numberOfWords()
    }

    @Test
    public void shouldVerifyContainmentOfWord() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        // TODO check that counter.containsWord("bar")
    }
}
