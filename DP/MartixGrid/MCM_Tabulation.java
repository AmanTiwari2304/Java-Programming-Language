package DP.MartixGrid;

public class MCM_Tabulation {
    public static int mcmTabu(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }

        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n-len; i++) {
                int j = i+len-1; // col
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    int finalCost =  cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                   
                }
            }
        }
        print(dp);
        return dp[1][n-1];        
    }

    public static void print(int dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr [] =  {1, 3, 5, 6};
        int n = arr.length;

        System.out.println(mcmTabu(arr));
    }
}
