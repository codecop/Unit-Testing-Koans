package org.codecop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Code samples how to use Java 8 features.
 */
public class LambdaCheatSheet {

    final String name = "Peter";
    final List<String> names = Arrays.asList(name);

    void codeSamples() {
        // Lambda Expression, anonymous function accessing enclosing scope
        Predicate<Integer> positive = n -> n > 0;
        IntFunction<Integer> inc = (int i) -> {
            return i + 1;
        };
        Supplier<String> hello = () -> "Hello";
        BiFunction<String, String, String> concat = (a, b) -> a + b;

        // Method Reference, using a single method in a Lambda Expression
        Consumer<List<String>> sort = Collections::sort; // static method
        Supplier<String> constructor = String::new; // constructor
        IntSupplier instanceLength = name::length; // instance method
        Function<String, Integer> len = String::length; // arbitrary method

        // Stream, a pipeline of functions to process and transform data
        names.stream(). // Stream<String>
                map(String::length). // Stream<Integer>
                filter(positive). // Stream<Integer> 
                collect(Collectors.toList()); // List<Integer>

        // avoid unused warnings
        assert inc != null;
        assert hello != null;
        assert concat != null;
        assert sort != null;
        assert constructor != null;
        assert instanceLength != null;
        assert len != null;
    }
}
