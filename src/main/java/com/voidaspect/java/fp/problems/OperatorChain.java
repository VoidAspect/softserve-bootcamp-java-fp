package com.voidaspect.java.fp.problems;

import java.util.Objects;
import java.util.function.UnaryOperator;

public final class OperatorChain<T> implements UnaryOperator<T> {

    private final Iterable<UnaryOperator<T>> operators;

    public static <T> OperatorChain<T> of(Iterable<UnaryOperator<T>> operators) {
        Objects.requireNonNull(operators);
        return new OperatorChain<>(operators);
    }

    private OperatorChain(Iterable<UnaryOperator<T>> operators) {
        this.operators = operators;
    }

    public UnaryOperator<T> combine() {
        return this;
    }

    public T apply(T value) {
        for (UnaryOperator<T> operator : operators) {
            value = operator.apply(value);
        }
        return value;
    }
}
