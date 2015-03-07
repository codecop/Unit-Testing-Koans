<?php

require_once 'WordCounter.php';

/**
 * Session 3: WordCounterFileTest - Fixtures, e.g. using a test file.
 * See https://phpunit.de/manual/current/en/fixtures.html
 * See https://phpunit.de/manual/current/en/appendixes.annotations.html
 */
class Session3_WordCounterFileTest extends \PHPUnit_Framework_TestCase {

    /** @test */
    function shouldReturnCountOfWords() {
        $file = "testfile.tmp";
        file_put_contents($file, "Keep the bar green to keep the code clean.");

        $counter = WordCounter::fromFile($file);
        $this->assertEquals(9, $counter->numberOfWords());

        unlink($file);
    }

    // the problem is that unlink is not called in case of test failure,
    // better use Before/After hooks for test file handling
    // TODO add the needed annotations to the hook methods and then
    // TODO add the proper assertions to complete the tests
    
    const TEST_FILE = "FileWordCounterTest.tmp";

    // TODO this needs to be called before each test
    function createFreshTestFileForEachTest() {
        file_put_contents(self::TEST_FILE,
            "Keep the bar green to keep the code clean.");
    }

    // TODO this needs to be called after each test
    function deleteTestFile() {
        $this->assertTrue(unlink(self::TEST_FILE));
    }

    /** @test */
    function shouldReturnCountOfWordsBetter() {
        // $counter = WordCounter::fromFile(self::TEST_FILE);
        // TODO check that 9, $counter->numberOfWords()
    }

    /** @test */
    function shouldVerifyContainmentOfWord() {
        // $counter = WordCounter::fromFile(self::TEST_FILE);
        // TODO check that $counter->containsWord("bar")
    }
}
