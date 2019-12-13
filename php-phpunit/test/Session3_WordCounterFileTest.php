<?php

use \Wordcount\WordCounter;

/**
 * Session 3: WordCounterFileTest - Fixtures, e.g. using a test file.
 * See https://phpunit.de/manual/current/en/fixtures.html
 * See https://phpunit.de/manual/current/en/appendixes.annotations.html
 */
class Session3_WordCounterFileTest extends \PHPUnit_Framework_TestCase {

    /** @test */
    function shouldReturnCountOfWords() {
        $file = "tmp";
        file_put_contents($file, "Keep the bar green to keep the code clean.");

        $counter = WordCounter::fromFile($file);
        $this->assertEquals(9, $counter->numberOfWords()); 

        unlink($file);
    }

    // The problem is that os.remove is not called in case of test failures.
    // Better use setUp/tearDown hooks for test file handling.

    const TEST_FILE = "FileWordCounterTest.tmp";

    // TODO Add the needed annotations to create and delete test files.

    // TODO This method should be called before each test.
    function createFreshTestFileForEachTest() {
        file_put_contents(self::TEST_FILE,
        "Keep the bar green to keep the code clean.");
    }

    // TODO This method should be called after each test.
    function deleteTestFile() {
        $this->assertTrue(unlink(self::TEST_FILE)); 
    }

    // TODO Add the proper assertions to complete the tests.

    /** @test */
    function shouldReturnCountOfWordsBetter() {
        $counter = WordCounter::fromFile(self::TEST_FILE);
        // TODO Check that 9, $counter->numberOfWords().
    }

    /** @test */
    function shouldVerifyContainmentOfWord() {
        $counter = WordCounter::fromFile(self::TEST_FILE);
        // TODO Check that $counter->containsWord("bar").
    }
}
