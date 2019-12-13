<?php

use \Wordcount\WordCounter;
use \Wordcount\FileNotFoundException;

/**
 * Session 4: WordCounterFailureTest - Exceptions and ignoring tests.
 * See https://phpunit.de/manual/current/en/writing-tests-for-phpunit.html#writing-tests-for-phpunit.exceptions
 * See https://phpunit.de/manual/current/en/appendixes.annotations.html
 */
class Session4_WordCounterFailureTest extends \PHPUnit_Framework_TestCase {

	// TODO Add the needed code/annotations to test for an expected exception.

    /**
     * @test
     * @expectedException \InvalidArgumentException
     */
    function shouldThrowInvalidArgumentExceptionForUnknownWord() {
        $counter = new WordCounter("green bar green");
        $counter->ratioOf("missingWord");
    }

    /**
     * @test
     * @expectedException \Wordcount\FileNotFoundException
     * @expectedExceptionMessage IamSureThisDoesNotExist.txt
     */
    function shouldThrowExceptionOnMissingFile() {
        WordCounter::fromFile("IamSureThisDoesNotExist.txt");
    }

    /**
     * @test
     */
    function shouldThrowIllegalArgumentExceptionWithMessageOnUnknownWord() {
        $this->setExpectedException("\InvalidArgumentException", "missingWord");
        $counter = new WordCounter("green bar green");
        $counter->ratioOf("missingWord");
    }

    // TODO The next test does not work, we need to change the code,
    // but we will do that tomorrow. For today let's skip it.

    /**
     * @test
     */
    function shouldCountUniqueWordsCaseInsensitive() {
        $counter = new WordCounter("green bar Green hat");
        $this->markTestIncomplete("work in progress, will continue tomorrow");
        $this->assertEquals([ "bar", "green", "hat" ], $counter->uniqueWords()); // keep
    }

}
