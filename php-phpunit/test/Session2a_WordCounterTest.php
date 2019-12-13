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
        $this->assertEquals(9, $counter->numberOfWords());
    }

    /** @test */
    function shouldNotCountCapitalizedWord() {
        $counter = new WordCounter("green bar green hat");
        $this->assertNotEquals(1, $counter->countOf("HAT"));
    }

    /** @test */
    function shouldVerifyContainmentOfWord() {
        $counter = new WordCounter("green bar green hat");
        $this->assertTrue($counter->containsWord("bar"));
    }

    /** @test */
    function shouldVerifyNonContainmentOfWord() {
        $counter = new WordCounter("green hat");
        $this->assertFalse($counter->containsWord("red"));
    }

    /** @test */
    function shouldReturnNullForUnknownWordCount() {
        $counter = new WordCounter("green bar green hat");
        $this->assertNull($counter->countOf("else"));
    }

    /** @test */
    function shouldReturnNotNullExistingWordCount() {
        $counter = new WordCounter("green bar green hat");
        $this->assertNotNull($counter->countOf("green"));
    }

    /** @test */
    function shouldCountGreenTwice() {
        $counter = new WordCounter("green bar green hat");
        $this->assertEquals(2, $counter->countOf("green"));
    }

    /** @test */
    function shouldFindUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        $this->assertEquals(["bar", "green", "hat"], $counter->uniqueWords());
    }

}
