package com.voidaspect.java.fp.problems;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class FindFreeDaysOfWeek {

    private final List<TimeSlot> slots;

    public static FindFreeDaysOfWeek of(List<TimeSlot> slots) {
        Objects.requireNonNull(slots);
        return new FindFreeDaysOfWeek(slots);
    }

    private FindFreeDaysOfWeek(List<TimeSlot> slots) {
        this.slots = slots;
    }

    public Set<DayOfWeek> result() {
        throw new UnsupportedOperationException("not implemented");
    }
}
