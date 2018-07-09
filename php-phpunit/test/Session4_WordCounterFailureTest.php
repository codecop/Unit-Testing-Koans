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
     * TODO Expect \InvalidArgumentException is thrown
     */
    function shouldThrowInvalidArgumentExceptionForUnknownWord() {
        $counter = new WordCounter("green bar green");
        $counter->ratioOf("missingWord");
    }

    /**
     * @test
     * TODO Expect \Wordcount\FileNotFoundException is thrown
     * TODO Expect exception message IamSureThisDoesNotExist.txt
     */
    function shouldThrowExceptionOnMissingFile() {
        WordCounter::fromFile("IamSureThisDoesNotExist.txt");
    }

    /**
     * @test
     */
    function shouldThrowIllegalArgumentExceptionWithMessageOnUnknownWord() {
        // TODO Expect "\InvalidArgumentException" is thrown with message "missingWord".
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
        // TODO Mark this test as incomplete with "work in progress, will continue tomorrow".
        $this->assertEquals([ "bar", "green", "hat" ], $counter->uniqueWords()); 
    }

}
