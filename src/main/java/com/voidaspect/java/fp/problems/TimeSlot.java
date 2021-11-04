package com.voidaspect.java.fp.problems;

import java.time.Duration;
import java.time.ZonedDateTime;

public record TimeSlot(ZonedDateTime start, Duration duration) {
}
