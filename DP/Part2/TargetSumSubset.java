public class TargetSumSubset {
    public static boolean targetSumSubset(int num[], int targetSum){
        int n = num.length;
        int W = targetSum;
        boolean dp[][] = new boolean[n+1][W+1];
        // BASE CASE
        //if sum is 0 then empty set or null
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        //we have 0 item and target sum is greater than 0
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int v = num[i-1];
                // include
                if (v <= j && dp[i-1][j-v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                else if(dp[i-1][j] == true){ 
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][W]; 
    }

    public static void print(boolean   dp[][]){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int num[] = {4, 2, 7, 1, 3};
        int targetSum = 10;
        System.out.println(targetSumSubset(num, targetSum));
    }
}
