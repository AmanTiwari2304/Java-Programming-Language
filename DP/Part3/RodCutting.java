
public class RodCutting {
    public static int rodCutting(int length[], int price[], int rodLength){
        int n = price.length;
        int W = length.length;
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) { // i is for price
            for (int j = 1; j < dp[0].length; j++) { // j is for length
                int v = length[i-1];
                if (v <= j) {
                    // include
                    int profit1 = price[i-1] + dp[i][j-v];
                    // exclude
                    int profit2 = dp[i-1][j];
                    dp[i][j] = Math.max(profit1, profit2);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
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
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;
        System.out.println(rodCutting(length, price, rodLength));

    }
    
}