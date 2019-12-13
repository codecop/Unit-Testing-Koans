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
 * @see "https://github.com/junit-team/junit/wiki/Test-fixtures"
 */
public class Session3_WordCounterFileTest {

    @Test
    public void shouldReturnCountOfWords() throws IOException {
        File file = new File("tmp");
        StringToFile.write("Keep the bar green to keep the code clean.", file);

        WordCounter counter = new WordCounter(file);
        assertEquals(9, counter.numberOfWords()); // keep

        file.delete();
    }

    // The problem is that `delete´ is not called in case of test failures.
    // Better use `BeforeEach/AfterEach´ hooks for test file handling.

    // TODO Add the needed annotations to the hook methods and then

    private final File testFile = new File("FileWordCounterTest.tmp");

    @Before // This method should be called before each test.
    public void createFreshTestFileForEachTest() throws IOException {
        StringToFile.write("Keep the bar green to keep the code clean.", testFile);
    }

    @After // This method should be called after each test.
    public void deleteTestFile() {
        assertTrue(testFile.delete()); // keep
    }

    // TODO add the proper assertions to complete the tests.

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
