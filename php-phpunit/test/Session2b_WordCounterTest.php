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
        $this->assertEquals(9, $counter->numberOfWords());
    }

    /** @test */
    function shouldContainUniqueWord() {
        $counter = new WordCounter("green bar green hat");
        $this->assertContains("bar", $counter->uniqueWords());
    }

    /** @test */
    function shouldNotContainUniqueWord() {
        $counter = new WordCounter("green bar green hat");
        $this->assertNotContains("foo", $counter->uniqueWords());
    }

    /** @test */
    function shouldReturnRatioOfWords() {
        $counter = new WordCounter("green bar green");
        $this->assertEquals(0.33, $counter->ratioOf("bar"), '', 0.01);
        // Note that floating point numbers need an accuracy delta, e.g. 0.01.
    }

    /** @test */
    function shouldVerifyFirstUniqueWordStartsWithB() {
        $counter = new WordCounter("green bar green");
        $this->assertRegExp("/^b/", $counter->firstUniqueWord());
    }

    /** @test */
    function shouldFindNumberOfUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        $this->assertCount(3, $counter->uniqueWords());
    }

}
