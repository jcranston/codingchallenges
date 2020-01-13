package main.java.com.codingchallenges.random_problems.max_single_sell_profit;

import java.util.Comparator;
import java.util.stream.Stream;

public class DivideAndConquerSolution implements MaxSingleSellProfit {
    @Override
    public OptimalSellStrategy findOptimalSellStrategy(int[] stockPrices) {
        OptimalSellStrategy strategy = divdeAndConquerSolution(stockPrices, 0, stockPrices.length);
        if (strategy.bestProfit < 1) {
            throw new RuntimeException("no optimal sell strategy");
        }
        return strategy;
    }

    private static OptimalSellStrategy divdeAndConquerSolution(int[] stockprices, int lowerIdx, int upperIdx) {
        int n = upperIdx - lowerIdx;
        if (n == 1) {
            return new OptimalSellStrategy(lowerIdx, lowerIdx, 0);
        }
        int midIdx = lowerIdx + (upperIdx - lowerIdx) / 2; // no integer overflow
        OptimalSellStrategy leftStrategy = divdeAndConquerSolution(stockprices, lowerIdx, midIdx);
        OptimalSellStrategy rightStrategy = divdeAndConquerSolution(stockprices, midIdx, upperIdx);
        if (leftStrategy == null || rightStrategy == null) {
            throw new RuntimeException("should not happen");
        }
        DayAndPrice leftMin = minOfSubarray(stockprices, lowerIdx, midIdx);
        DayAndPrice rightMax = maxOfSubarray(stockprices, midIdx, upperIdx);
        int profit = rightMax.price - leftMin.price;
        OptimalSellStrategy crossStrategy = new OptimalSellStrategy(leftMin.day, rightMax.day, profit);

        OptimalSellStrategy strategy = Stream.of(leftStrategy, crossStrategy, rightStrategy).max(
                Comparator.comparingInt((OptimalSellStrategy s) -> s.bestProfit)
        ).orElseGet(null);

        return strategy;
    }

    private static class DayAndPrice {
        int day;
        int price;

        DayAndPrice(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    private static DayAndPrice maxOfSubarray(int[] stockPrices, int lowerIdx, int upperIdx) {
        int max = -1;
        int dayWithMax = lowerIdx;
        for (int i = lowerIdx; i < upperIdx; i++) {
            if (stockPrices[i] > max) {
                max = stockPrices[i];
                dayWithMax = i;
            }
        }
        return new DayAndPrice(dayWithMax, max);
    }

    private static DayAndPrice minOfSubarray(int[] stockPrices, int lowerIdx, int upperIdx) {
        int min = Integer.MAX_VALUE;
        int dayWithMin = lowerIdx;
        for (int i = lowerIdx; i < upperIdx; i++) {
            if (stockPrices[i] < min) {
                min = stockPrices[i];
                dayWithMin = i;
            }
        }
        return new DayAndPrice(dayWithMin, min);
    }
}
