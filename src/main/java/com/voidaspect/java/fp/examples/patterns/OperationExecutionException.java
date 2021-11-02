package com.voidaspect.java.fp.examples.patterns;

public class OperationExecutionException extends Exception {

    public OperationExecutionException() {
        super();
    }

    public OperationExecutionException(String message) {
        super(message);
    }

    public OperationExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationExecutionException(Throwable cause) {
        super(cause);
    }

}
