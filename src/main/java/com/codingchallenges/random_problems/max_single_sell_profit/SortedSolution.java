package main.java.com.codingchallenges.random_problems.max_single_sell_profit;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortedSolution implements MaxSingleSellProfit {
    @Override
    public OptimalSellStrategy findOptimalSellStrategy(int[] stockPrices) {
        // create list of (idx, stockPrice) pairs
        List<IdxAndStockPrice> idxToStockPrice =
            IntStream
                .range(0, stockPrices.length)
                .mapToObj(i -> new IdxAndStockPrice(i, stockPrices[i]))
                .collect(Collectors.toList());

        // sort pairs of (idx, stockPrice) by increasing stock price
        idxToStockPrice.sort(Comparator.comparingInt(e -> e.stockPrice));

        int i = 0;
        int j = idxToStockPrice.size() - 1;

        // loop invariant ensures we are attempting to compute a positive profit
        while (i < j) {
            int leftIdx = idxToStockPrice.get(i).idx;
            int rightIdx = idxToStockPrice.get(j).idx;
            int profit = idxToStockPrice.get(j).stockPrice - idxToStockPrice.get(i).stockPrice;

            // ensures that our buy day is less than our sell day.
            // since the list is sorted by stockPrice values, the first instance we
            // see that leftIdx < rightIdx, that will yield the greatest profit, so
            // long as the loop invariants are maintained to obtain a correct solution
            if (leftIdx < rightIdx) {
                return new OptimalSellStrategy(leftIdx, rightIdx, profit);
            }
            // if there is at least 1 (idx, stockPfrice) pair between i and j,
            // then compare the following values:
            // - the change in stock price by comparing stock price at index i and index i + 1
            // - the change in stock price by comparing stock price at index j - 1 and index j
            // which ever one is smaller, make a change to i or make a change to j, accordingly
            // this ensures that if our buy day is greater than our sell day, we make a change
            // to the values we are comparing while minimizing the decrease in profit
            // 3 4 5
            if (i + 1 <= j) {
                int leftProfitDelta = idxToStockPrice.get(i + 1).stockPrice - idxToStockPrice.get(i).stockPrice;
                int rightProfitDelta = idxToStockPrice.get(j).stockPrice - idxToStockPrice.get(j - 1).stockPrice;
                if (leftProfitDelta < rightProfitDelta) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        throw new RuntimeException("no optimal sell solution");
    }

    private static class IdxAndStockPrice {
        int idx;
        int stockPrice;
        IdxAndStockPrice(int idx, int stockPrice) {
            this.idx = idx;
            this.stockPrice = stockPrice;
        }
    }
}
