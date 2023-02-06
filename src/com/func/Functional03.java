package com.func;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Functional03 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        /*numbers.stream()
                .filter(x -> x%2==0)
                .map(x -> x*x)
                .forEach(System.out::println);*/

        // Predicate is used when you have 1 input to your lambda function and you would want a boolean back
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number%2==0;
            }
        };

        // Function will take 1 input and return one output back
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * number;
            }
        };

        // Function will take 1 input and return one output back
        Function<Integer, String> stringOutputFunction = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return " "+integer;
            }
        };

        // Binary operator takes 2 inputs and returns 1 input back
        BinaryOperator<Integer> sumBinaryOperatorImpl = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer baseNumber, Integer additiveNumber) {
                return baseNumber + additiveNumber;
            }
        };

        // Consumer takes one input and consumes it
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println(number);
            }
        };

        Supplier<Integer> randomIntSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random rand = new Random();

                return rand.nextInt(100);
            }
        };

        UnaryOperator<Integer> unaryDoublingOperator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer o) {
                return o*2;
            }
        };

        int sumOfEvenSquares = numbers.stream()
                .filter(predicate)
                .map(function)
                .map(unaryDoublingOperator)
                .reduce(sumBinaryOperatorImpl)
                .stream().findFirst().get();

        System.out.println(sumOfEvenSquares);
        System.out.println(randomIntSupplier.get());

        // BiPredicate is used when you have 2 inputs to your lambda function and you would want a boolean back
        BiPredicate<Integer,String> testStringIntegerEquivalent = (x,y) -> {
          return x == Integer.parseInt(y);
        };
        System.out.println(testStringIntegerEquivalent.test(2,"3"));

        // BiFunction will take 2 inputs and return one output back. Output can be of a different type
        BiFunction<Integer, String, String> appenderBiFunction = (x,y) -> x+y;
        System.out.println(appenderBiFunction.apply(2,"342"));

        // BiConsumer takes two inputs and consumes them
        BiConsumer<Integer,String> biConsumerPrinter = (x,y) -> System.out.println(x+"----"+y);
        biConsumerPrinter.accept(2,"342");

        // IntBinaryOperator takes in two int arguments and return an int.
        // It increases efficiency by avoiding boxing/unboxing required in generic BinaryOperator
        IntBinaryOperator intBinaryOperator = (x,y) -> x+y ;
    }
}
