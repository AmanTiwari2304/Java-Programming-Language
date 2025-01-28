public class Array {
    public static boolean isNumsAppearstwice(int nums[]){
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] == nums[j])) {
                    count ++;
                } 
            }
            if (count>1) {
                return true;
            }
        }
        return false;
    }

    public static int profitOnStocks(int prices[]){
        int maxProfit = 0;
        int buyPrices = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if ( buyPrices < prices[i]) {
                maxProfit = prices[i] - buyPrices;
                maxProfit = Math.max(maxProfit, prices[i]);
            } else {
                buyPrices = prices[i];
            }
        }
        return maxProfit;

    }

    public static int trackTarget(int nums[], int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
        
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 0, 4, 7, 6, 5};
        int target = 0;
        System.out.println("We got the target it is at index number : " + trackTarget(nums, target));
        
        // int prices[] = {7, 1, 5, 3, 6, 4};
        // System.out.println("Max Profit is equal to : " + profitOnStocks(prices));
        // System.out.println(isNumsAppearstwice(nums));
    }
}
