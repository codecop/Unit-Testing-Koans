<?php
namespace Wordcount;

class Greeter {

    const GREETING = "Hello";

    /**
     * Return a proper greeting for a person.
     */
    public function greet($name) {
        if (empty($name)) {
            return self::GREETING;
        }
        return self::GREETING . " " . trim($name);
    }
}
