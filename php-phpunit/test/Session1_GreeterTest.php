<?php

require 'Greeter.php';

/**
 * Session 1: GreeterTest - Your first tests.
 */
class Session1_GreeterTest extends \PHPUnit_Framework_TestCase {

    /** @test */
    function shouldReturnHelloName() {
        $greeter = new Greeter();
        $this->assertEquals("Hello Peter", $greeter->greet("Peter"));
    }

    // add another test method, what about null?

    /** @test */
    function shouldReturnHelloForNull() {
        $greeter = new Greeter();
        $this->assertEquals("Hello", $greeter->greet(null));
    }

    // add another test method, what about blanks?

    /** @test */
    function shouldIgnoreWhitespace() {
        $greeter = new Greeter();
        $this->assertEquals("Hello Peter", $greeter->greet(" Peter "));
    }

}
