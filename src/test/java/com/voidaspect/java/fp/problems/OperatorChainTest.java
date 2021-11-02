package com.voidaspect.java.fp.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorChainTest {

    private static final Pattern NON_ALPHANUMERIC_OR_WHITESPACE = Pattern.compile("[^a-zA-Z\\d\\s]");

    @Test
    @DisplayName("should combine multiple unary operators into 1")
    void testCombine() {

        List<UnaryOperator<String>> operators01 = List.of(
                string -> NON_ALPHANUMERIC_OR_WHITESPACE.matcher(string).replaceAll(""),
                String::toLowerCase,
                String::strip);
        assertEquals("test case 01", OperatorChain.of(operators01).combine().apply("  Test cAsE #01 ~"));

        List<UnaryOperator<String>> operators02 = List.of(UnaryOperator.identity());
        assertEquals("test case 02", OperatorChain.of(operators02).combine().apply("test case 02"));
    }
}