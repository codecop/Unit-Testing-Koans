package org.codecop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

/**
 * Session 5: WordCounterRatioTest - Dynamic/table driven tests. <br />
 * See http://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests
 */
class Session5_WordCounterRatioTest {

    // TODO Add the needed code/annotations to run this test with all examples.

    @Test
    public void convinceIntelliJThatThisIsValidJUnit5Test() {
        // convince IntelliJ that this is a valid JUnit5 test
    }

    // We want to test more corner cases for the ratio. Here is a table of test cases.
    private static final List<TestCase> TEST_CASES = Arrays.asList(//
            new TestCase("green", "green", 1.0), //
            new TestCase("green bar green", "green", 0.66), //
            new TestCase("green bar green bar", "green", 0.5), //
            new TestCase("green bar green", "bar", 0.33) //
    );

    private static class TestCase {

        private final String sentence;
        private final String word;
        private final double expectedRatio;

        TestCase(String sentence, String word, double expectedRatio) {
            this.sentence = sentence;
            this.word = word;
            this.expectedRatio = expectedRatio;
        }

        String name() {
            return String.format("ratio of '%s' in words '%s' should be %s", word, sentence, expectedRatio);
        }

        void shouldReturnRatioOfGivenWord() {
            WordCounter counter = new WordCounter(sentence);
            assertEquals(expectedRatio, counter.ratioOf(word), 0.01); // keep
        }
    }

    @TestFactory // Test factory will create a sequence of tests.
    List<DynamicTest> createTests() {
        // TODO Take data from TEST_CASES field and convert it to list of DynamicTests.
        // use return Collections.<DynamicTest>emptyList().stream(). //
        // use        collect(Collectors.toList());
        return TEST_CASES.stream(). // drop
                map(testCase -> DynamicTest.dynamicTest(testCase.name(), testCase::shouldReturnRatioOfGivenWord)). // drop
                collect(Collectors.toList()); // drop
    }
}
