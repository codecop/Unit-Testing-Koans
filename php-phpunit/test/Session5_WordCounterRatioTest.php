<?php

require_once 'WordCounter.php';

/**
 * Session 5: WordCounterTableTest - parametrized/table driven.
 * See https://phpunit.de/manual/current/en/writing-tests-for-phpunit.html#writing-tests-for-phpunit.data-providers
 */
class Session5_WordCounterRatioTest extends \PHPUnit_Framework_TestCase {

    // we want to test more corner cases for the ratio, here is a table of test cases
    static function tableData() {
        return [
            [ "green", "green",               1.0 ], //
            [ "green bar green", "green",     0.66 ], //
            [ "green bar green bar", "green", 0.5 ], //
            [ "green bar green", "bar",       0.33 ] //
        ];
    }

    // TODO add the needed code/annotations to run this test with all examples
    
    /**
     * @ test
     * TODO take data from tableData method
     */
    function shouldReturnRatioOfGivenWord($sentence, $word, $expectedRratio) {
        $counter = new WordCounter($sentence);
        $this->assertEquals($expectedRratio, $counter->ratioOf($word), '', 0.01);
    }
    
    /** @test */
    function fakeTestForExerciseToAvoidPHPUnitWarning() {
        $this->assertTrue(true);
        // TODO delete this test at the end
    }
}
