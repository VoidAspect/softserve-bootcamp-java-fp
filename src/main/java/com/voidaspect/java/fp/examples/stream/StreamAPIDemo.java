package com.voidaspect.java.fp.examples.stream;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public final class StreamAPIDemo {

    public static final class FindShortestWord {

        public static void main(String[] args) {

            var scanner = new Scanner(System.in);

            Stream.generate(scanner::next)
                    .limit(5)
                    .min(Comparator.comparingInt(String::length))
                    .ifPresent(System.out::println);
        }

    }

    public static final class StringToInteger {

        public static void main(String[] args) {
            List<String> strings = List.of("1", "2 a", "~ 3");
            strings.stream()
                    .flatMapToInt(String::chars)
                    .filter(Character::isDigit)
                    .map(c -> Character.digit(c, 10))
                    .reduce((result, digit) -> result * 10 + digit)
                    .ifPresent(System.out::println);
        }

    }


    public static final class FindNamesWithSpaces {

        public static void main(String[] args) {
            List<String> names = List.of("Irene", "Zhao Liang", "Romulus", "Richard Matthew");

            //region solution
            List<String> withSpaces = names.stream()
                    .filter(name -> name.contains(" "))
                    .toList();
            //endregion

            System.out.println(withSpaces);
        }

    }

    public static final class GroupStringsByLength {

        public static void main(String[] args) {
            List<String> strings = List.of("xxx", "xx", "x", "yyy", "zzz");

            //region solution
            Map<Integer, List<String>> groupByLength = strings.stream().collect(groupingBy(String::length));
            //endregion

            String output = groupByLength.entrySet().stream()
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .collect(joining(System.lineSeparator()));
            System.out.println(output);
        }
    }

    public static final class FindPositiveAndNegativeNotEqualToZero {

        public static void main(String[] args) {
            int[] numbers = {2, -5, 0, 124, 32, -1432, 432, 566, -1, 1, 10, 2, 0, -1};

            //region solution
            Map<Boolean, Set<Integer>> positiveAndNegative = Arrays.stream(numbers)
                    .filter(num -> num != 0)
                    .boxed()
                    .collect(partitioningBy(num -> num > 0, toSet()));
            //endregion

            System.out.println("Positive: " + positiveAndNegative.get(true));
            System.out.println("Negative: " + positiveAndNegative.get(false));
        }

    }

    public static final class FindPositiveAndNegativeNotEqualToZeroSortByAbsoluteValue {

        public static void main(String[] args) {
            int[] numbers = {2, -5, 0, 124, 32, -1432, 432, 566, -1, 1, 10, 2, 0, -1};

            //region solution
            Map<Boolean, Set<Integer>> positiveAndNegative = Arrays.stream(numbers)
                    .filter(num -> num != 0)
                    .boxed()
                    .collect(partitioningBy(
                            num -> num > 0,
                            toCollection(() -> new TreeSet<>(Comparator.comparingInt(Math::abs)))));
            //endregion

            System.out.println("Positive: " + positiveAndNegative.get(true));
            System.out.println("Negative: " + positiveAndNegative.get(false));
        }

    }

    public static final class GenerateRandomUUIDs {

        public static Stream<UUID> generate(int limit) {
            return Stream.generate(UUID::randomUUID).limit(limit);
        }

        public static void main(String[] args) {
            String output = generate(20)
                    .map(UUID::toString)
                    .collect(joining(System.lineSeparator()));
            System.out.println(output);
        }

    }

}
