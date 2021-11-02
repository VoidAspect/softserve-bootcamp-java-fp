package com.voidaspect.java.fp.examples.patterns.demo;

import com.voidaspect.java.fp.examples.patterns.OperationQueue;
import com.voidaspect.java.fp.examples.patterns.PanicOnFailure;

public class LineBufferOperationsDemo {

    public static void main(String[] args) {

        var lineBuffer = LineBuffer.of("""
                Line 1: Roses are Red,
                Line 2: Violets are Blue,
                Line 3: Java is Awesome,
                Line 4: And so are all of you!
                """);

        var operationQueue = new OperationQueue(new PanicOnFailure());

        operationQueue.enqueue(new PrintLineOperation(lineBuffer));

        operationQueue.enqueue(new MoveDownOperation(lineBuffer));
        operationQueue.enqueue(new PrintLineOperation(lineBuffer));

        operationQueue.enqueue(new MoveDownOperation(lineBuffer));
        operationQueue.enqueue(new PrintLineOperation(lineBuffer));

        operationQueue.enqueue(new MoveDownOperation(lineBuffer));
        operationQueue.enqueue(new PrintLineOperation(lineBuffer));

        operationQueue.executeAll();
    }

}
