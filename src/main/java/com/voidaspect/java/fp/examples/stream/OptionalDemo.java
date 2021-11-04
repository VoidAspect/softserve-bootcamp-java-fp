package com.voidaspect.java.fp.examples.stream;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public class OptionalDemo {

    // M<T> flatMap (T -> M<R>) -> M<R>
    // M<T> bind (T) -> M<T>
    // M<T> map (T -> R) -> M<R> == flatMap ( T -> bind ( T ) )

    public static void main(String[] args) {

        var lineReader = new LineReader(new Scanner(System.in));

        System.out.println("Enter your nickname:");

        Optional<String> nickname = lineReader.next();

        nickname.map("Welcome, %s!%n"::formatted)
                .ifPresent(System.out::print);

        if (nickname.isPresent()) {
            System.out.println("Enter your occupation:");
        }

        nickname.flatMap(value -> lineReader.next()
                        .map(occupation -> "Ok, %s is a %s.%n".formatted(value, occupation)))
                .ifPresent(System.out::print);
    }
}

class LineReader {

    private final Scanner scanner;

    LineReader(Scanner scanner) {
        this.scanner = scanner;
    }

    Optional<String> next() {
        return Optional.ofNullable(scanner.nextLine())
                .filter(Predicate.not(String::isBlank))
                .map(String::trim);
    }
}
