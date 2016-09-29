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
 * See http://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations
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

    // the problem is that delete is not called in case of test failure,
    // better use BeforeEach/AfterEach hooks for test file handling

    private final File testFile = new File("FileWordCounterTest.tmp");

    @BeforeEach
    void createFreshTestFileForEachTest() throws IOException {
        StringToFile.write("Keep the bar green to keep the code clean.", testFile);
    }

    @AfterEach
    void deleteTestFile() {
        assertTrue(testFile.delete());
    }

    @Test
    void shouldReturnCountOfWordsBetter() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        assertEquals(9, counter.numberOfWords());
    }

    @Test
    void shouldVerifyContainmentOfWord() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        assertTrue(counter.containsWord("bar"));
    }
}
