<?php

require_once 'WordCounter.php';

/**
 * Session 4: WordCounterTest - testing for Exceptions.
 * See https://phpunit.de/manual/current/en/writing-tests-for-phpunit.html#writing-tests-for-phpunit.exceptions
 * See https://phpunit.de/manual/current/en/appendixes.annotations.html
 */
class Session4_WordCounterTest extends \PHPUnit_Framework_TestCase {

    // expected to test Exception, Trainer should show this one

    /**
     * @test
     * @expectedException InvalidArgumentException
     */
    function shouldThrowInvalidArgumentExceptionForUnknownWord() {
        $counter = new WordCounter("green bar green");
        $counter->ratioOf("missingWord");
    }

    // now do the second one yourself

    /**
     * @test
     * @expectedException FileNotFoundException
     * @expectedExceptionMessage IamSureThisDoesNotExist.txt
     */
    function shouldThrowExceptionOnMissingFile() {
        WordCounter::fromFile("IamSureThisDoesNotExist.txt");
    }

    // add a test but it is not implemented yet. Let them write a test,
    // then it does not work, we need to change the code,
    // will do that tomorrow. for the time skip it

    /**
     * @test
     */
    function shouldCountUniqueWordsCaseInsensitive() {
        $counter = new WordCounter("green bar Green hat");
        $this->markTestIncomplete("work in progress, will continue tomorrow");
        $this->assertEquals([ "bar", "green", "hat" ], $counter->uniqueWords());
    }

}
