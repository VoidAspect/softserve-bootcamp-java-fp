package com.voidaspect.java.fp.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindFreeDaysOfWeekProblemTest {

    @Test
    @DisplayName("find free days of week given a schedule")
    void testSolution() {
        assertAll(
                () -> test(EnumSet.allOf(DayOfWeek.class)),
                () -> test(
                        EnumSet.noneOf(DayOfWeek.class),
                        slot("2021-07-12T12:00:00Z", Duration.ofDays(120))
                ),
                () -> test(
                        EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY),
                        slot("2021-07-12T12:00:00Z", Duration.ofDays(4))),
                () -> test(
                        EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY),
                        slot("2021-07-05T12:00:00Z", Duration.ofHours(1)),
                        slot("2021-07-05T14:00:00Z", Duration.ofHours(1)),
                        slot("2021-07-13T12:00:00Z", Duration.ofHours(1)),
                        slot("2021-07-21T12:00:00Z", Duration.ofHours(1)),
                        slot("2021-07-29T12:00:00Z", Duration.ofHours(1)),
                        slot("2021-08-06T12:00:00Z", Duration.ofHours(1))),
                () -> test(
                        EnumSet.complementOf(EnumSet.of(DayOfWeek.MONDAY)),
                        slot("2021-07-12T22:59:00Z", Duration.ofHours(1))
                ),
                () -> test(
                        EnumSet.complementOf(EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY)),
                        slot("2021-07-12T22:59:00Z", Duration.ofMinutes(61))
                )
        );
    }

    private void test(Set<DayOfWeek> expected, TimeSlot... schedule) {
        assertEquals(expected, FindFreeDaysOfWeek.of(Arrays.asList(schedule)).result());
    }

    private static TimeSlot slot(String time, Duration duration) {
        return new TimeSlot(ZonedDateTime.parse(time), duration);
    }

}