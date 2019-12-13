package org.codecop;

public class Greeter {

    private static final String GREETING = "Hello";

    /**
     * Return a proper greeting for a person.
     */
    public String greet(String name) {
        if (name == null) {
            return GREETING;
        }
        return GREETING + " " + name.trim();
    }
}
