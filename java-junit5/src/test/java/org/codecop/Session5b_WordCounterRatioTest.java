package org.codecop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Session 5b: WordCounterRatioTest - (experimental) parameterised/table driven tests. <br />
 * @see "https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests"
 *
 * @author Daniel Mühlbachler
 */
class Session5b_WordCounterRatioTest {

    // TODO Add the needed annotations to run this test with all examples.

    @Test
    void convinceIntelliJThatThisIsValidJUnit5Test() {
        // convince IntelliJ that this is a valid JUnit5 test
    }

    // We want to test more cases for the ratio. Here is a table of test cases.
    static Stream<Arguments> getTestCases() {
        return Stream.of(//
                Arguments.of("green", "green", 1.0), //
                Arguments.of("green bar green", "green", 0.66), //
                Arguments.of("green bar green bar", "green", 0.5), //
                Arguments.of("green bar green", "bar", 0.33) //
        );
    }

    @ParameterizedTest // mark this test as parameterised
    @MethodSource("getTestCases") // tell it to take arguments from "getTestCases"  
    void shouldReturnRatioOfGivenWord(String sentence, String word, double expectedRatio) {
        WordCounter counter = new WordCounter(sentence);
        assertEquals(expectedRatio, counter.ratioOf(word), 0.01); // keep
    }

}
