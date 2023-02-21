package com.func;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class FuntionalParallelized {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        System.out.println(LongStream.range(0,1000000000)
                        .sum());
        long after = System.currentTimeMillis();
        System.out.println("Time taken = "+(after-before));

        // Parallel
        before = System.currentTimeMillis();
        System.out.println(LongStream.range(0,1000000000)
                        .parallel()
                        .sum());
        after = System.currentTimeMillis();
        System.out.println("Time taken = "+(after-before));
    }
}
