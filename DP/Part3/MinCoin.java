package DP.Part3;

public class MinCoin {
    
    public static int minCoins(int coins[], int sum) {
        // code here
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];
        int count = -1;
        if(sum == 0){
            return 0;
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]] , dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                
                if(dp[i][j] == sum){
                    count ++;
                }    
            }
        }
        print(dp);
        return count;
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
        System.out.println(minCoins(coins, sum));
    }
}
