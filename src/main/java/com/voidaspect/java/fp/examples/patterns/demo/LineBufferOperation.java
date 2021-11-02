package com.voidaspect.java.fp.examples.patterns.demo;

import com.voidaspect.java.fp.examples.patterns.Operation;

public abstract class LineBufferOperation implements Operation {

    protected final LineBuffer lineBuffer;

    protected LineBufferOperation(LineBuffer lineBuffer) {
        this.lineBuffer = lineBuffer;
    }

}
