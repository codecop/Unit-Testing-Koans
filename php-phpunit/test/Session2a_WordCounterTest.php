<?php

use \Wordcount\WordCounter;

/**
 * Session 2: WordCounterTest - Basic assertions.
 * See https://phpunit.de/manual/current/en/appendixes.assertions.html
 */
class Session2_WordCounterTest extends \PHPUnit_Framework_TestCase {

    // TODO Add the proper assertions to complete the tests.
    // The test name explains what needs to be asserted.

    /** @test */
    function shouldCountNumberOfWords() {
        $counter = new WordCounter("Keep the bar green to keep the code clean.");
        // TODO Check that 9, $counter->numberOfWords().
    }

    /** @test */
    function shouldNotCountCapitalizedWord() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that 1, $counter->countOf("HAT") is not equal.
    }

    /** @test */
    function shouldVerifyContainmentOfWord() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that $counter->containsWord("bar").
    }

    /** @test */
    function shouldVerifyNonContainmentOfWord() {
        $counter = new WordCounter("green hat");
        // TODO Check that $counter->containsWord("red") is false.
    }

    /** @test */
    function shouldReturnNullForUnknownWordCount() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that $counter->countOf("else") is null.
    }

    /** @test */
    function shouldReturnNotNullExistingWordCount() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that $counter->countOf("green") is not null.
    }

    /** @test */
    function shouldCountGreenTwice() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that 2, $counter->countOf("green").
    }

    /** @test */
    function shouldFindUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that ["bar", "green", "hat"], $counter->uniqueWords().
    }

}
