package Greedy.Questions;

import java.util.*;


public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int value = 729;

        // sorting in descending order
        Arrays.sort(coins, Collections.reverseOrder());
        int capacity = value;
        int MinNumOFCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i<coins.length; i++) {
            while (coins[i] <= capacity) {
                capacity -= coins[i];
                ans.add(coins[i]);
                MinNumOFCoins ++;
            }
            if (capacity == 0) {
                break;
            }
        }

        System.out.println("Minimum number of note or coin required = " + MinNumOFCoins);

        for (int i = 0; i < ans.size(); i++) {
           System.out.print(ans.get(i)+ " "); 
        }

    }
}
