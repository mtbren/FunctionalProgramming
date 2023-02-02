package com.func;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Functional02 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring","Spring Boot", "Azure", "AWS", "Docker", "Kubernetes");

        System.out.println(addNumbersInListFunctional(numbers));
        //System.out.println(doubledNumbersInListFunctional(numbers));
    }
    private static <T extends Number> List<Integer>
        doubledNumbersInListFunctional(List<? extends Number> numbers){
            return numbers
                .stream()
                .map(x -> x.intValue()*2)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber){
        //System.out.println(aggregate+" "+nextNumber);
        return aggregate+nextNumber;
    }
    private static int addNumbersInListFunctional(List<Integer> numbers){
        //return numbers.stream()
        // .reduce(0,Functional02::sum); // using a function reference

        //return numbers.stream()
        // .reduce(0, (x,y)->x+y); // using a lambda expression

        // return numbers.stream().reduce(0, Integer::sum);
        //System.out.println(numbers.stream().reduce((x,y) -> x+y).get());

        //BinaryOperator<Integer> sumBinaryOperator = Integer::sum;


        BinaryOperator<Integer> sumBinaryOperatorImpl = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer baseNumber, Integer additiveNumber) {
                return baseNumber + additiveNumber;
            }
        };

        return numbers.stream().reduce(0, sumBinaryOperatorImpl);
    }



}
