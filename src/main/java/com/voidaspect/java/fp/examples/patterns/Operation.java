package com.voidaspect.java.fp.examples.patterns;

@FunctionalInterface
public interface Operation {

    void execute() throws OperationExecutionException;

}
