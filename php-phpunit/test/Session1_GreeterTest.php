<?php

require 'Greeter.php';

/**
 * Session 1: GreeterTest - Your first tests.
 */
class Session1_GreeterTest extends \PHPUnit_Framework_TestCase {

    // TODO we will add the proper assertions together
    
    /** @test */
    function shouldReturnHelloName() {
        $greeter = new Greeter();
        // TODO check that "Hello Peter", $greeter->greet("Peter")
    }

    /** @test */
    function shouldReturnHelloForNull() {
        $greeter = new Greeter();
        // TODO check that "Hello", $greeter->greet(null)
    }

    /** @test */
    function shouldIgnoreWhitespace() {
        $greeter = new Greeter();
        // TODO check that "Hello Peter", $greeter->greet(" Peter ")
    }

}
