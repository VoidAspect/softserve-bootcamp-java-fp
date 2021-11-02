package com.voidaspect.java.fp.examples.patterns;

@FunctionalInterface
public interface OperationFailureHandler {

    void handle(OperationExecutionException exception);

}
