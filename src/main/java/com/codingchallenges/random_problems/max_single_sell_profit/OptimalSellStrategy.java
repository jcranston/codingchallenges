package main.java.com.codingchallenges.random_problems.max_single_sell_profit;

public class OptimalSellStrategy {
    public int buyDay;
    public int sellDay;
    public int bestProfit;

    public OptimalSellStrategy(int buyDay, int sellDay, int bestProfit) {
        this.buyDay = buyDay;
        this.sellDay = sellDay;
        this.bestProfit = bestProfit;
    }
}