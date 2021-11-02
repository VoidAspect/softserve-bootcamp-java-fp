package com.voidaspect.java.fp.examples.patterns;

public class PanicOnFailure implements OperationFailureHandler {
    @Override
    public void handle(OperationExecutionException exception) {
        throw new UncheckedOperationExecutionException(exception);
    }
}
