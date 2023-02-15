package com.func;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        System.out.println(Stream.of(1,3,5,7,9).count());

        System.out.println(Stream.of(1,3,5,7,9).reduce((x,y)->x+y).get());

        System.out.println(Stream.of(1,3,5,7,9).reduce(0,Integer::sum));

        // Following 2 are of the same type, they hold instances of wrapper classes, not very efficient,
        // since boxing/unboxing is needed
        System.out.println(Stream.of(1,3,5,7,9));
        System.out.println(List.of(1,3,5,7,9).stream());

        // This is better since the stream contains primitive int values
        System.out.println(Arrays.stream(new int[]{1,3,5,7,9}));

        // Since its an IntPipeline, lot of functions are avialble out of the box
        System.out.println(Arrays.stream(new int[]{1,3,5,7,9}).max());
        System.out.println(Arrays.stream(new int[]{1,3,5,7,9}).average());
        System.out.println(Arrays.stream(new int[]{1,3,5,7,9}).min());
        System.out.println(Arrays.stream(new int[]{1,3,5,7,9}).sum());


        System.out.println(IntStream.range(1,10).sum());
        System.out.println(IntStream.rangeClosed(1,10).sum());
        System.out.println();
        System.out.println();
        System.out.println(IntStream.iterate(0,e -> e+3).limit(10).max().getAsInt());

        System.out.println(IntStream.iterate(2,x->x+2).limit(10).peek(System.out::println).sum());

        // To be able to collect from a primitive stream, you need to box them into a wrapper class using boxed()
        System.out.println(IntStream.iterate(2, e->e*2).limit(10).boxed().collect(Collectors.toList()));

        System.out.println(LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply));

    }
}
