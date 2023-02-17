package com.func;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Functional04 {

    public static void main(String[] args) {
        List<String> strings = List.of("Spring", "Spring Boot", "Azure",
                "AWS", "Docker", "Kubernetes", "Kafka", "Hadoop");

        System.out.println(strings.stream().collect(Collectors.joining("---")));

        // The following does not work
        //System.out.println(strings.stream().map(str -> str.split("")).collect(Collectors.toList()));

        // With Flatmap, each stream is replaced with content of mapped stream
        System.out.println(
                strings.stream()
                        .map(str -> str.split(""))
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList())
        );

        // Get distinct characters from the original streams
        System.out.println(
                strings.stream()
                        .map(str -> str.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList())
        );

        List<String> strings1 = List.of("Spring", "Spring Boot", "Azure",
                "AWS", "Docker", "Kubernetes", "Kafka", "Hadoop");

        List<String> strings2 = List.of("Spring", "Spring Boot", "Azure",
                "AWS", "Docker", "Kubernetes", "Kafka", "Hadoop");

        System.out.println(
                strings1.stream()
                        .flatMap(str1 -> strings2.stream()
                                                    .filter(str2 -> str2.length()==str1.length())
                                                    .map(str2 -> List.of(str1,str2)))
                        .filter(x -> !x.get(0).equals(x.get(1)))
                        .collect(Collectors.toList())
        );


    }
}
