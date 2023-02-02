package com.func;

import java.util.List;

public class Functional01 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring","Spring Boot", "Azure", "AWS", "Docker", "Kubernetes");
        //printAllNumbersInListFunctional(numbers);
        //printEvenNumbersInListFunctional(numbers);
        //printOddNumbersInListFunctional(numbers);
        //printAllCoursesInListFunctional(courses);
        //printSpringCoursesInListFunctional(courses);
        //printCoursesWith4LettersInListFunctional(courses);
        //printSquaresOfEvenNumbersInListFunctional(numbers);
        //printCubesOfOddNumbersInListFunctional(numbers);
        printNumberOfCharactersInCoursesInListFunctional(courses);
    }
    private static void printNumberOfCharactersInCoursesInListFunctional(List<String> courses){
        courses.stream()
                .map(course -> course.length())
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number%2==1)
                .map(number -> (int)Math.pow(number,3))
                .forEach(System.out::println);
    }
    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number%2==0)
                .map(number -> number*number)
                .forEach(System.out::println);
    }

    private static void printCoursesWith4LettersInListFunctional(List<String> courses){
        courses.stream().filter(course -> course.length()>3).forEach(System.out::println);
    }
    private static void printSpringCoursesInListFunctional(List<String> courses){
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }
    private static void printAllCoursesInListFunctional(List<String> courses){
        courses.stream().forEach(System.out::println);
    }
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // First way to do it
        //numbers.stream().forEach(number -> System.out.println(number));

        // Second way to do it
        //numbers.stream().forEach(Functional01::printOneNumber); // Syntax of Method Reference

        // Third way to do it
        numbers.stream().forEach(System.out::println);
    }
    private static void printOneNumber(int number){
        System.out.println(number);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(n -> n%2 == 1).forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        // First way to do it
        numbers.stream().filter(Functional01::isEven).forEach(Functional01::printOneNumber);
        // Second way to do it
        //numbers.stream().filter(n -> n%2==0).forEach(System.out::println);
    }

    private static boolean isEven(int number){
        return number % 2 == 0;
    }
}
