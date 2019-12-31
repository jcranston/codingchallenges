package main.java.com.codingchallenges.random_problems;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public abstract class ReservoirSampling {
    public static int[] sampleReservoir(Stream<Integer> stream, int k) {
        int[] reservoir = new int[k];
        AtomicLong count = new AtomicLong(0L);

        stream.forEach( t -> {
            long n = count.incrementAndGet();
            if (n <= k) {
                reservoir[(int)(n - 1L)] = t;
            } else {
                // if random number chosen from the values [1, n] inclusive is between [1, k] inclusive
                boolean willEvictElement = ThreadLocalRandom.current().nextLong(n) + 1L <= (long) k;
                if (willEvictElement) {
                    // pick random index between [0, k-1] inclusive to evict
                    int idxToEvict = ThreadLocalRandom.current().nextInt(k);
                    reservoir[idxToEvict] = t;
                }
            }
        });

        return reservoir;
    }
}
