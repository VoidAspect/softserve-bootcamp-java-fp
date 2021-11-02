package com.voidaspect.java.fp.examples.patterns.demo;

public class PrintLineOperation extends LineBufferOperation {

    public PrintLineOperation(LineBuffer lineBuffer) {
        super(lineBuffer);
    }

    @Override
    public void execute() {
        System.out.println(lineBuffer.get());
    }
}
