package com.algorithm.java.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{8, 1, 5, 3, 6, 4};

        System.out.println(new BestTimeToBuyAndSellStock().bruteForce(prices)); // 5
    }

    // timeout
    public int bruteForce(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    // 저점과 현재 값과의 차이 계산
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);

            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
