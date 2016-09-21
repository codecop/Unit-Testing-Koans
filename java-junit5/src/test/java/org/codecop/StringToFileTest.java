package org.codecop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class StringToFileTest {

    private final File testFile = new File("StringToFileTest.tmp");

    @AfterEach
    void deleteTestFile() {
        testFile.delete();
    }

    @Test
    void shouldWriteAndRead() throws IOException {
        String original = "Keep the bar green to keep the code clean.";
        StringToFile.write(original, testFile);
        assertEquals(original, StringToFile.read(testFile));
    }
}
