package com.voidaspect.java.fp.examples.patterns.demo;

import java.util.List;

public final class LineBuffer {

    private int position;

    private final int last;

    private final List<String> lines;

    public static LineBuffer of(String text) {
        List<String> lines = text.lines().toList();
        return new LineBuffer(lines);
    }

    private LineBuffer(List<String> lines) {
        this.lines = lines;
        this.last = lines.size() - 1;
    }

    public boolean up() {
        boolean canMoveUp = position > 0;
        if (canMoveUp) {
            position--;
        }
        return canMoveUp;
    }

    public boolean down() {
        boolean canMoveUp = position < last;
        if (canMoveUp) {
            position++;
        }
        return canMoveUp;
    }

    public String get() {
        return lines.get(position);
    }

    public int size() {
        return lines.size();
    }

    public int position() {
        return position;
    }
}
