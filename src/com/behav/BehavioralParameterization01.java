package com.behav;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class BehavioralParameterization01 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        /*List<String> courses = List.of("Spring","Spring Boot", "Azure", "AWS",
                "Docker", "Kubernetes");*/

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        //filterAndPrint(numbers, isEvenPredicate);

        //Predicate<Integer> isOddPredicate = x -> x % 2 != 0;
        //filterAndPrint(numbers, x -> x%2 != 0);

        calulateAndPrint(numbers, (x) -> x*x*x);
    }
    private static void calulateAndPrint(List<Integer> numbers, Function<Integer, Integer> func){
        numbers.stream().map(func).forEach(System.out::println);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
