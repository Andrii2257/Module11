package hw4;

import java.util.stream.Stream;

public class InfiniteStreamOfRandomNumbers {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = System.currentTimeMillis();

        Stream<Long> randomStream = Stream.iterate(seed, x -> (a * x + c) % m);
        randomStream.limit(10).forEach(System.out::println);
    }
}

