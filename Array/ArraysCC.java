import java.util.*;

public class ArraysCC {
    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1 ;
        }
    }

    public static void largestNum(int numbers[]){
        int largestNumber = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > largestNumber) {
                largestNumber = numbers[i];
            }
        }
        System.out.println("Largest number of array is : "+largestNumber);
    }

    public static int binarySearch(int numbers[], int key){
        int start = 0, end = numbers.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;

            //comparisions
            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                start = mid + 1;
            }
            if (numbers[mid] > key) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void reverseArray(int numbers[]){
        int start = 0, end = numbers.length-1;
        while (start < end) { 
            int trans = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = trans;
            start++ ;
            end-- ;
        }  
    }

    public static void pairsOfArray(int numbers[]){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                System.out.print("(" + numbers[i] +","+ numbers[j] +")");
            }
            System.out.println();
        }
        
    }
    
    public static void subArrays(int numbers[]){
        int totalpair = 0;
        int largestNumOFSubArrays = Integer.MIN_VALUE;
        int smallestNumOFSubArrays = Integer.MAX_VALUE;
        for (int i = 0; i <= numbers.length; i++) {
            for (int j = i; j <= numbers.length; j++) {
                int sumOfSubArrays = 0;
                for (int j2 = i; j2 < j; j2++) {
                    System.out.print(numbers[j2]+" ");
                    totalpair++;
                    sumOfSubArrays = sumOfSubArrays + numbers[j2] ;
                }
                System.out.println("Sum of the sub arrays is : "+sumOfSubArrays);
                if (largestNumOFSubArrays < sumOfSubArrays) {
                    largestNumOFSubArrays = sumOfSubArrays;
                }
                if (smallestNumOFSubArrays > sumOfSubArrays) {
                    smallestNumOFSubArrays = sumOfSubArrays;
                }
            }
            System.out.println();
        }
        System.out.println("Total numbers of pair : "+totalpair);
        System.out.println("Largest number of sum of array is : "+largestNumOFSubArrays);
        System.out.println("Smallest number of sum of array is : "+smallestNumOFSubArrays);
    }

    public static void prefixSum(int numbers[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        //Calculate prefix array
        prefix[0] = numbers[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = 0; j < numbers.length; j++) {
                int end = j;

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max Sum = " + maxSum);
    }

    public static void kadanes(int numbers[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }

        System.out.println("Our max subarray sum is : " + ms);
    }

    public static void trappedRainWater(int height[]){
        int n = height.length;
        // left max boundary:-
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        //Right max boundary:-
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        //loop:-
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i] ;
        }
        System.out.println(trappedWater);

    }

    public static void main(String[] args) {
        // int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int numbers[] = {1, -2, 6, -1, 3};
        int height[] = {4, 2, 6, 3, 2, 5};
        // int key = 10;
        // update(marks);
        // largestNum(numbers);
        // System.err.println("Index of your key is : "+ binarySearch(numbers, key));
        // reverseArray(numbers);
        // for (int i = 0; i < numbers.length; i++) {
        //     System.out.print(numbers[i] + ", " );
        // }
        // pairsOfArray(numbers);
        // subArrays(numbers);
        // prefixSum(numbers);
        // kadanes(numbers);
        trappedRainWater(height);
        

       
    }
}
