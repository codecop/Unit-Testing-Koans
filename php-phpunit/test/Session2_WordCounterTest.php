<?php

require_once 'WordCounter.php';

/**
 * Session 2: WordCounterTest - All kind of assertions.
 * See https://phpunit.de/manual/current/en/appendixes.assertions.html
 */
class Session2_WordCounterTest extends \PHPUnit_Framework_TestCase {

    // TODO add the proper assertions to complete the tests,
    // the test name explains what needs to be verified

    /** @test */
    function shouldCountNumberOfWords() {
        $counter = new WordCounter("Keep the bar green to keep the code clean.");
        // TODO check that 9, $counter->numberOfWords()
    }

    /** @test */
    function shouldVerifyContainmentOfWord() {
        $counter = new WordCounter("green bar green hat");
        // TODO check that $counter->containsWord("bar")
    }

    /** @test */
    function shouldVerifyNonContainmentOfWord() {
        $counter = new WordCounter("green hat");
        // TODO check that $counter->containsWord("red")
    }

    /** @test */
    function shouldReturnNullForUnknownWordCount() {
        $counter = new WordCounter("green bar green hat");
        // TODO check that $counter->countOf("else") is null
    }

    /** @test */
    function shouldReturnNotNullWordCountForExistingWord() {
        $counter = new WordCounter("green bar green hat");
        // TODO check that $counter->countOf("green") is not null
    }

    /** @test */
    function shouldCountGreenTwice() {
        $counter = new WordCounter("green bar green hat");
        // TODO check that 2, $counter->countOf("green")
    }

    /** @test */
    function shouldFindUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        // TODO check that ["bar", "green", "hat"], $counter->uniqueWords()
    }

    /** @test */
    function shouldContainUniqueWord() {
        $counter = new WordCounter("green bar green hat");
        // TODO check that "bar", $counter->uniqueWords() is contained in list
        // TODO check that "foo", $counter->uniqueWords() is not contained in list
    }

    /** @test */
    function shouldFindNumberOfUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        // TODO check that 3, $counter->uniqueWords()
    }

    /** @test */
    function shouldReturnRatioOfWords() {
        $counter = new WordCounter("green bar green");
        // TODO check that 0.33, $counter->ratioOf("bar")
        // note that floating point numbers have accuracy delta 0.01
    }

}
