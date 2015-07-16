package org.codecop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Session 4: WordCounterFileTest - Before and After for WordCounter.
 */
public class Session3_WordCounterFileTest {

    // write a real test, with a test file (trainer should show that method)

    @Test
    public void shouldReturnCountOfWords() throws IOException {
        File file = new File("tmp");
        StringToFile.write("Keep the bar green to keep the code clean.", file);

        WordCounter counter = new WordCounter(file);
        assertEquals(9, counter.numberOfWords());

        file.delete();
    }

    // problem that delete is not called in case of failure, better use Before/After
    // the code is the same as shown, just moved to different methods

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

    // add second test, reuse Before and After (also repeat assert from previous lession)

    @Test
    public void shouldVerifyContainmentOfWord() throws IOException {
        WordCounter counter = new WordCounter(testFile);
        assertTrue(counter.containsWord("bar"));
    }
}
