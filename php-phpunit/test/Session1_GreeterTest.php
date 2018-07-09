<?php

use \Wordcount\Greeter;

/**
 * Session 1: GreeterTest - Your first tests.
 */
class Session1_GreeterTest extends \PHPUnit_Framework_TestCase {

    // TODO We will add the proper self.assertions together.

    /** @test */
    function shouldReturnHelloName() {
        $greeter = new Greeter();
        // TODO Check that "Hello Peter", $greeter->greet("Peter").
    }

    /** @test */
    function shouldReturnHelloForNull() {
        $greeter = new Greeter();
        // TODO Check that "Hello", $greeter->greet(null).
    }

    /** @test */
    function shouldIgnoreWhitespace() {
        $greeter = new Greeter();
        // TODO Check that "Hello Peter", $greeter->greet(" Peter ").
    }

}
