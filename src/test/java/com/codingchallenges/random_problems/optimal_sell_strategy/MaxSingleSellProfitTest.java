package test.java.com.codingchallenges.random_problems.optimal_sell_strategy;

import main.java.com.codingchallenges.random_problems.optimal_sell_strategy.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MaxSingleSellProfitTest {
    private static MaxSingleSellProfit[] algorithms = null;

    @BeforeClass
    public static void setUp() {
        algorithms = new MaxSingleSellProfit[]{
//            new BruteForceSolution(),
            new SortedSolution(),
//            new DivideAndConquerSolution(),
            // new OptimizedDivideAndConquerSolution()
        };
    }

    @Test
    public void testNormalInput() {
        int[] stockPrices = new int[]{17, 22, 3, 2, 9, 15, 10};
        try {
            Arrays.stream(algorithms).forEach(alg -> {
                OptimalSellStrategy strategy = alg.findOptimalSellStrategy(stockPrices);
                assertEquals(3, strategy.buyDay);
                assertEquals(5, strategy.sellDay);
                assertEquals(13, strategy.bestProfit);
            });
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testNoSellStrategy() {
        int[] stockPrices = new int[]{17, 17, 14, 8, 3};
        Arrays.stream(algorithms).forEach(alg -> {
            try {
                OptimalSellStrategy strategy = alg.findOptimalSellStrategy(stockPrices);
                fail();
            } catch (Exception e) {
                // pass
            }
        });
    }

    @Test
    public void testEqualProfitsOnMultipleDays() {
        int[] stockPrices = new int[]{2, 8, 1, 7};
        try {
            Arrays.stream(algorithms).forEach(alg -> {
                OptimalSellStrategy strategy = alg.findOptimalSellStrategy(stockPrices);
                assertEquals(0, strategy.buyDay);
                assertEquals(1, strategy.sellDay);
                assertEquals(6, strategy.bestProfit);
            });
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Taken from https://www.keithschwarz.com/interesting/code/?dir=single-sell-profit
     */
    @Test
    public void testWithKeithSchwarzExample() {
        int[] stockPrices = new int[]{2, 7, 1, 8, 2, 8, 4, 5, 9, 0, 4, 5};
        try {
            Arrays.stream(algorithms).forEach(alg -> {
                OptimalSellStrategy strategy = alg.findOptimalSellStrategy(stockPrices);
                assertEquals(2, strategy.buyDay);
                assertEquals(8, strategy.sellDay);
                assertEquals(8, strategy.bestProfit);
            });
        } catch (Exception e) {
            fail();
        }
    }
}