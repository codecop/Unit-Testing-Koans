package org.codecop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Session 3: WordCounterFileTest - Fixtures, e.g. using a test file. <br />
 * @see "https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations"
 */
class Session3_WordCounterFileTest {

    @Test
    void shouldReturnCountOfWords() throws IOException {
        File file = new File("tmp");
        StringToFile.write("Keep the bar green to keep the code clean.", file);

        WordCounter counter = new WordCounter(file);
        assertEquals(9, counter.numberOfWords());

        file.delete();
    }

    // The problem is that `delete´ is not called in case of test failures.
    // Better use `BeforeEach/AfterEach´ hooks for test file handling.

    // TODO Add the needed annotations to the hook methods and then

    private final File testFile = new File("FileWordCounterTest.tmp");

    // TODO This method should be called before each test.
    void createFreshTestFileForEachTest() throws IOException {
        StringToFile.write("Keep the bar green to keep the code clean.", testFile);
    }

    // TODO This method should be called after each test.
    void deleteTestFile() {
        assertTrue(testFile.delete());
    }

    // TODO add the proper assertions to complete the tests.

    @Test
    void shouldReturnCountOfWordsBetter() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        // TODO Check that 9, counter.numberOfWords().
    }

    @Test
    void shouldVerifyContainmentOfWord() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        // TODO Check that counter.containsWord("bar").
    }
}
