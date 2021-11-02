package com.voidaspect.java.fp.examples.patterns.demo;

import com.voidaspect.java.fp.examples.patterns.OperationExecutionException;

public class MoveUpOperation extends LineBufferOperation {

    public MoveUpOperation(LineBuffer lineBuffer) {
        super(lineBuffer);
    }

    @Override
    public void execute() throws OperationExecutionException {
        if (!lineBuffer.up()) {
            String message = "LineBuffer: can't move up! size = %d position = %d"
                    .formatted(lineBuffer.size(), lineBuffer.position());
            throw new OperationExecutionException(message);
        }
    }
}
