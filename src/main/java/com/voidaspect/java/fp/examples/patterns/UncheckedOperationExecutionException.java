package com.voidaspect.java.fp.examples.patterns;

public class UncheckedOperationExecutionException extends RuntimeException {

    public UncheckedOperationExecutionException(OperationExecutionException cause) {
        super(cause);
    }

    @Override
    public synchronized OperationExecutionException getCause() {
        return (OperationExecutionException) super.getCause();
    }

}
