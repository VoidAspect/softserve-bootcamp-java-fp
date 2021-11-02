package com.voidaspect.java.fp.examples.patterns.demo;

import com.voidaspect.java.fp.examples.patterns.OperationExecutionException;

public class MoveDownOperation extends LineBufferOperation {

    public MoveDownOperation(LineBuffer lineBuffer) {
        super(lineBuffer);
    }

    @Override
    public void execute() throws OperationExecutionException {
        if (!lineBuffer.down()) {
            String message = "LineBuffer: can't move down! size = %d position = %d"
                    .formatted(lineBuffer.size(), lineBuffer.position());
            throw new OperationExecutionException(message);
        }
    }
}
