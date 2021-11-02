package com.voidaspect.java.fp.examples.patterns.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;

public class StandardFunctionalInterfacesDemo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "s1", "s2", "long");
        strings.removeIf(string -> string.length() > 3);
        strings.forEach(System.out::println);

        String concatenated = reduce(strings, (s1, s2) -> s1 + " " + s2);
        System.out.println(concatenated);
    }

    public static String reduce(Iterable<String> strings, BinaryOperator<String> function) {
        var iterator = strings.iterator();
        if (!iterator.hasNext()) return null;
        String result = iterator.next();

        while (iterator.hasNext()) {
            result = function.apply(result, iterator.next());
        }
        return result;
    }
}
