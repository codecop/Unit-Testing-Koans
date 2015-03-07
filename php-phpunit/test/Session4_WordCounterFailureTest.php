<?php

require_once 'WordCounter.php';

/**
 * Session 4: WordCounterTest - testing for Exceptions.
 * See https://phpunit.de/manual/current/en/writing-tests-for-phpunit.html#writing-tests-for-phpunit.exceptions
 * See https://phpunit.de/manual/current/en/appendixes.annotations.html
 */
class Session4_WordCounterFailureTest extends \PHPUnit_Framework_TestCase {

    // TODO add the needed code/annotations to test for an expected exception, then
    // TODO enable the tests to complete them
    
    /**
     * @ test
     * TODO expect InvalidArgumentException
     */
    function shouldThrowInvalidArgumentExceptionForUnknownWord() {
        $counter = new WordCounter("green bar green");
        $counter->ratioOf("missingWord");
    }

    /**
     * @ test
     */
    function shouldThrowInvalidArgumentExceptionAlternative() {
        // TODO expect "InvalidArgumentException"
        $counter = new WordCounter("green bar green");
        $counter->ratioOf("anotherMissingWord");
    }

    /**
     * @ test
     * TODO expect FileNotFoundException
     * TODO expect message IamSureThisDoesNotExist.txt
     */
    function shouldThrowExceptionWithFileNameOnMissingFile() {
        WordCounter::fromFile("IamSureThisDoesNotExist.txt");
    }

    // the next test does not work, we need to change the code,
    // but we will do that tomorrow. for today ignore it

    /**
     * @ test
     */
    function shouldCountUniqueWordsCaseInsensitive() {
        $counter = new WordCounter("green bar Green hat");
        // TODO mark test incomplete with "work in progress, will continue tomorrow"
        $this->assertEquals([ "bar", "green", "hat" ], $counter->uniqueWords());
    }

    /** @test */
    function fakeTestForExerciseToAvoidPHPUnitWarning() {
        $this->assertTrue(true);
        // TODO delete this test at the end
    }
    
}
