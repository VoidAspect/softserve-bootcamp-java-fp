package com.voidaspect.java.fp.examples.patterns;

public interface OperationFailureHandler {

    void handle(OperationExecutionException exception);

}
