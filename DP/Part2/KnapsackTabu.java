package DP.Part2;

import java.util.Arrays;

public class KnapsackTabu {
    public static int knapsackTabu(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        
        // intialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = val[i-1]; // ith item val
                int w = wt[i-1]; // ith item weight
                if (w <= j) {// valid
                    // include
                    int profit1 = v + dp[i-1][j-w];
                    // exclude
                    int profit2 = dp[i-1][j];
                    dp[i][j] = Math.max(profit1, profit2);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7; // capacity
        System.out.println(knapsackTabu(val, wt, W));
        
    }
}
