<?php

require_once 'WordCounter.php';

/**
 * Session 2: WordCounterTest - All kind of asserts.
 * See https://phpunit.de/manual/current/en/appendixes.assertions.html
 */
class Session2_WordCounterTest extends \PHPUnit_Framework_TestCase {

    // $this->assertEquals - just show

    /** @test */
    function shouldReturnCountOfWords() {
        $counter = new WordCounter("Keep the bar green to keep the code clean.");
        $this->assertEquals(9, $counter->numberOfWords());
    }

    // $this->assertTrue - show everything but the assert line

    /** @test */
    function shouldVerifyContainmentOfWord() {
        $counter = new WordCounter("green bar green hat");
        $this->assertTrue($counter->containsWord("bar"));
    }

    // $this->assertFalse - let do themselves

    /** @test */
    function shouldVerifyNonContainmentOfWord() {
        $counter = new WordCounter("green hat");
        $this->assertFalse($counter->containsWord("red"));
    }

    // $this->assertNull

    /** @test */
    function shouldReturnNullForUnknownWordCount() {
        $counter = new WordCounter("green bar green hat");
        $this->assertNull($counter->countOf("else"));
    }

    // $this->assertNotNull

    /** @test */
    function shouldReturnWordCount() {
        $counter = new WordCounter("green bar green hat");
        $this->assertNotNull($counter->countOf("green"));
        $this->assertEquals(2, $counter->countOf("green"));
    }

    // $this->assertEquals also for arrays

    /** @test */
    function shouldFindUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        $this->assertEquals(["bar", "green", "hat"], $counter->uniqueWords());
        $this->assertContains("bar", $counter->uniqueWords());
    }
    
    // $this->assertCount

    /** @test */
    function shouldFindNumberOfUniqueWords() {
        $counter = new WordCounter("green bar green hat");
        $this->assertCount(3, $counter->uniqueWords());
    }

    // $this->assertEquals(float expected, float actual, message, float delta)

    /** @test */
    function shouldReturnRatioOfWords() {
        $counter = new WordCounter("green bar green");
        $this->assertEquals(0.33, $counter->ratioOf("bar"), '', 0.01);
    }

}
