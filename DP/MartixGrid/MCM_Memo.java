package DP.MartixGrid;

import java.util.Arrays;

public class MCM_Memo {
    public static int mcmMemo(int arr[], int dp[][] , int i, int j){
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = mcmMemo(arr, dp, i, k);
            int cost2 = mcmMemo(arr, dp, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
            
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        int arr [] =  {1, 3, 5, 6};
        int n = arr.length;
        int i = 1;
        int j = n-1;

        int dp[][] = new int[n][n];
        for (int k = 0; k < dp.length; k++) {
            Arrays.fill(dp[k], -1);
        }
        System.out.println(mcmMemo(arr, dp, i, j));
    }
}
