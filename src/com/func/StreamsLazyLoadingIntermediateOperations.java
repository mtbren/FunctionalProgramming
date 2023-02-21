package com.func;

import java.util.List;
import java.util.stream.Stream;

public class StreamsLazyLoadingIntermediateOperations {
    public static void main(String[] args) {

            List<String> courses = List.of("Spring", "Spring Boot", "Azure","Microservices",
                    "AWS", "Docker", "Kubernetes", "Kafka", "Hadoop");

        Stream<String> coursesStream = courses.stream()
                .peek(System.out::println)
                .filter(str -> str.length()>11)
                .map(String::toUpperCase)
                .peek(System.out::println);


        System.out.println("This will be surprisingly printed first !!");
        // The System.out.println on the intermediate steps above is only called when the terminal operation is executed
        // All intermediate operations on streams are lazy. They are executed only when the terminal operation is executed.
        // This makes them efficient

        coursesStream.findFirst();

        }
}
