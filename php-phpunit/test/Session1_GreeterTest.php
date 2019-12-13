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
        $this->assertEquals("Hello Peter", $greeter->greet("Peter"));
    }

    /** @test */
    function shouldReturnHelloForNull() {
        $greeter = new Greeter();
        $this->assertEquals("Hello", $greeter->greet(null));
    }

    /** @test */
    function shouldIgnoreWhitespace() {
        $greeter = new Greeter();
        $this->assertEquals("Hello Peter", $greeter->greet(" Peter "));
    }

}
