<?php

use \Wordcount\WordCounter;

/**
 * Bonus Session 2c: WordCounterTest - Assertions with Hamcrest.
 * See https://github.com/hamcrest/hamcrest-php
 */
class Session2c_WordCounterTest extends \PHPUnit_Framework_TestCase {

    // TODO Add the proper assertions to complete the tests using Hamcrest.

    /** @test */
    function shouldCountNumberOfWords() {
        $counter = new WordCounter("Keep the bar green to keep the code clean.");
        $this->assertEquals(9, $counter->numberOfWords()); 
        // Hamcrest improves readability:
        // TODO Check that $counter->numberOfWords(), equalTo 9.
    }

    /** @test */
    function shouldContainUniqueWord() {
        $counter = new WordCounter("green bar green hat");
        $this->assertContains("bar", $counter->uniqueWords()); 
        // Hamcrest improves readability:
        // TODO Check that $counter->uniqueWords(), hasItem "bar".
    }

    /** @test */
    function shouldNotContainUniqueWord() {
        $counter = new WordCounter("green bar green hat");
        $this->assertNotContains("foo", $counter->uniqueWords()); 
        // Hamcrest improves readability:
        // TODO Check that $counter->uniqueWords(), not hasItem "foo".
    }

    /** @test */
    function shouldFindNumberOfUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        $this->assertCount(3, $counter->uniqueWords()); 
        // Hamcrest improves readability:
        // TODO Check that $counter->uniqueWords(), arrayWithSize 3.
    }

}
