package com.voidaspect.java.fp.problems;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.*;

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
        Set<DayOfWeek> daysOfWeek = EnumSet.allOf(DayOfWeek.class);

        slots.stream()
                .forEach(timeSlot -> {
                    long durationInSeconds = Duration.ofHours(timeSlot.start().getHour()).toSeconds() + Duration.ofMinutes(timeSlot.start().getMinute()).toSeconds() + timeSlot.start().getSecond() + timeSlot.duration().toSeconds();
                    if (durationInSeconds >= Duration.ofDays(1).toSeconds()) {
                        for (int i = 0; i <= durationInSeconds; i += Duration.ofDays(1).toSeconds()) {
                            if ((timeSlot.start().getDayOfWeek().getValue() + i / Duration.ofDays(1).toSeconds()) <= DayOfWeek.values().length) {
                                daysOfWeek.remove(DayOfWeek.of((timeSlot.start().getDayOfWeek().getValue() + i / (int) Duration.ofDays(1).toSeconds())));
                            }
                            else break;
                        }
                    } else if (timeSlot.duration().toSeconds() > 0 && timeSlot.duration().toHours() <= 24) {
                        daysOfWeek.remove(timeSlot.start().getDayOfWeek());
                    }
                });
        return daysOfWeek;
    }
}
