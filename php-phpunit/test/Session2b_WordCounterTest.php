<?php

use \Wordcount\WordCounter;

/**
 * Session 2b: WordCounterTest - More assertions.
 * See https://phpunit.de/manual/current/en/appendixes.assertions.html
 */
class Session2b_WordCounterTest extends \PHPUnit_Framework_TestCase {

    // TODO Add the proper assertions to complete the tests.

    /** @test */
    function shouldCountNumberOfWords() {
        $counter = new WordCounter("Keep the bar green to keep the code clean.");
        // TODO Check that 9, $counter->numberOfWords().
    }

    /** @test */
    function shouldContainUniqueWord() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that "bar", $counter->uniqueWords() is contained.
    }

    /** @test */
    function shouldNotContainUniqueWord() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that "foo", $counter->uniqueWords() is not contained.
    }

    /** @test */
    function shouldReturnRatioOfWords() {
        $counter = new WordCounter("green bar green");
        // TODO Check that 0.33, $counter->ratioOf("bar"), "".
        // Note that floating point numbers need an accuracy delta, e.g. 0.01.
    }

    /** @test */
    function shouldVerifyFirstUniqueWordStartsWithB() {
        $counter = new WordCounter("green bar green");
        // TODO Check that "/^b/", $counter->firstUniqueWord() is regexp.
    }

    /** @test */
    function shouldFindNumberOfUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        // TODO Check that 3, $counter->uniqueWords() is count.
    }

}
