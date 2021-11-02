package com.voidaspect.java.fp.examples.patterns;

import java.util.ArrayDeque;
import java.util.Queue;

public class OperationQueue {

    private final OperationFailureHandler defaultErrorHandlingStrategy;

    private final Queue<Operation> operations = new ArrayDeque<>();

    public OperationQueue(OperationFailureHandler defaultErrorHandlingStrategy) {
        this.defaultErrorHandlingStrategy = defaultErrorHandlingStrategy;
    }

    public void enqueue(Operation operation) {
        if (operation != null) {
            operations.add(operation);
        }
    }

    public int size() {
        return operations.size();
    }

    public void executeFirst() {
        executeFirst(defaultErrorHandlingStrategy);
    }

    public void executeAll() {
        executeAll(defaultErrorHandlingStrategy);
    }

    public void execute(int amount) {
        execute(amount, defaultErrorHandlingStrategy);
    }

    public void executeFirst(OperationFailureHandler errorHandlingStrategy) {
        execute(1, errorHandlingStrategy);
    }

    public void executeAll(OperationFailureHandler errorHandlingStrategy) {
        execute(size(), errorHandlingStrategy);
    }

    public void execute(int amount, OperationFailureHandler errorHandlingStrategy) {
        amount = Math.min(amount, operations.size());
        for (int i = 0; i < amount; i++) {
            Operation operation = operations.remove();
            try {
                operation.execute();
            } catch (OperationExecutionException e) {
                errorHandlingStrategy.handle(e);
            }
        }
    }

}
