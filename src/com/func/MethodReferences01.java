package com.func;

import java.util.List;
import java.util.function.Supplier;

public class MethodReferences01 {

    private static void print(String str){
        System.out.println(str);
    }
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "MicroServices", "AWS", "PCF",
                "Azure", "Docker", "Kubernetes");

        /*courses.stream().map(str->str.toUpperCase())
                .forEach(str -> System.out.println(str));*/

        courses.stream()
                .map(String::toUpperCase)
                //.forEach(System.out::println);
                .forEach(MethodReferences01::print);

        Supplier<String> supplier = String::new;

    }
}
