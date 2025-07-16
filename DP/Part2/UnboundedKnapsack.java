package DP.Part2;

public class UnboundedKnapsack {
    public static int unboundedKnapsack(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        // In java we can ignore the initialzation for index zero,  
        // because it will fill zero automatically

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = wt[i-1];
                if (v <= j) { //valid condition
                    int profit1 = val[i-1] + dp[i][j-v];//include
                    int profit2 = dp[i-1][j];//exclude
                    dp[i][j] = Math.max(profit1, profit2);
                } else {
                    dp[i][j] = dp[i-1][j];//exclude
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7; // capacity
        System.out.println(unboundedKnapsack(val, wt, W));
    }
}
