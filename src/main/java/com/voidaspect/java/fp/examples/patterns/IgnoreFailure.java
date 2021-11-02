package com.voidaspect.java.fp.examples.patterns;

public class IgnoreFailure implements OperationFailureHandler {
    @Override
    public void handle(OperationExecutionException exception) {
    }
}
