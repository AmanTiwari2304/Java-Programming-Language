package DP.UnboundedKnapsack;

public class MinCoin {
    
    public static int minCoins(int coins[], int sum, int i) {
        // Base Case
        if (sum == 0) {
            return 0;
        }

        if (sum < 0 || i == coins.length) {
            return Integer.MAX_VALUE;
        }

        int take = Integer.MAX_VALUE;

        if (coins[i] > 0) {
            take = minCoins(coins, sum - coins[i], i);
            if (take != Integer.MAX_VALUE) {
                take++;
            }
        }
        
        int noTake = minCoins(coins, sum, i+1);
        return Math.min(take, noTake);
    }

    public static void print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int coins[] = {25, 10, 5}; 
        int sum = 30;
        int count = 0;
        if (minCoins(coins, sum, count) != Integer.MAX_VALUE) {
           System.out.println(minCoins(coins, sum, count)); 
        }else{
            System.out.println(-1);
        }
        
    }
}
