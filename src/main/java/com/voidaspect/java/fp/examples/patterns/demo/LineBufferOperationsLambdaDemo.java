package com.voidaspect.java.fp.examples.patterns.demo;

import com.voidaspect.java.fp.examples.patterns.Operation;
import com.voidaspect.java.fp.examples.patterns.OperationQueue;

public class LineBufferOperationsLambdaDemo {
    public static void main(String[] args) {
        var lineBuffer = LineBuffer.of("""
                Line 1: Roses are Red,
                Line 2: Violets are Blue,
                Line 3: Java is Awesome,
                Line 4: And so are all of you!
                """);

        var operationQueue = new OperationQueue(Throwable::printStackTrace);

        operationQueue.enqueue(lineBuffer::up);

        Operation printLine = () -> System.out.println(lineBuffer.get());

        operationQueue.enqueue(printLine);
        operationQueue.enqueue(lineBuffer::down);

        operationQueue.enqueue(printLine);
        operationQueue.enqueue(lineBuffer::down);

        operationQueue.enqueue(printLine);
        operationQueue.enqueue(lineBuffer::down);

        operationQueue.enqueue(printLine);
        operationQueue.enqueue(printLine);

        operationQueue.executeAll();
    }
}
