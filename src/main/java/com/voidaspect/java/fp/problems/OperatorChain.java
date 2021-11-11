package com.voidaspect.java.fp.problems;

import java.util.Objects;
import java.util.Collection;
import java.util.function.UnaryOperator;

public final class OperatorChain<T> {

    private final Iterable<UnaryOperator<T>> operators;

    public static <T> OperatorChain<T> of(Iterable<UnaryOperator<T>> operators) {
        Objects.requireNonNull(operators);
        return new OperatorChain<>(operators);
    }

    private OperatorChain(Iterable<UnaryOperator<T>> operators) {
        this.operators = operators;
    }

    public UnaryOperator<T> combine() {
        return t -> {
            for (UnaryOperator<T> operator : operators) {
                t = operator.apply(t);
            }
            return t;
        };
    }
}
