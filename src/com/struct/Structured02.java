package com.struct;

import java.util.List;

public class Structured02 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //printAllNumbersInListStructured(numbers);
        System.out.println(addNumbersInListStructured(numbers));
    }
    private static int addNumbersInListStructured(List<Integer> numbers){
        int sum=0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }
}
