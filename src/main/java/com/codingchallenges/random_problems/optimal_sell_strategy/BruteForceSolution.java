package main.java.com.codingchallenges.random_problems.optimal_sell_strategy;

public class BruteForceSolution implements MaxSingleSellProfit {
    @Override
    public OptimalSellStrategy findOptimalSellStrategy(int[] stockPrices) {
        int bestProfit = 0;
        OptimalSellStrategy strategy = null;
        for (int i = 0; i < stockPrices.length - 1; i++) {
            for (int j = i + 1; j < stockPrices.length; j++) {
                int potentialProfit = stockPrices[j] - stockPrices[i];
                if (potentialProfit > bestProfit) {
                    bestProfit = potentialProfit;
                    strategy = new OptimalSellStrategy(i, j, bestProfit);
                }
            }
        }
        if (strategy != null) {
            return strategy;
        } else {
            throw new RuntimeException("no optimal sell strategy");
        }
    }
}
