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
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
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

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // int key = 10;
        // update(marks);
        // largestNum(numbers);
        // System.err.println("Index of your key is : "+ binarySearch(numbers, key));
        // reverseArray(numbers);
        // for (int i = 0; i < numbers.length; i++) {
        //     System.out.print(numbers[i] + ", " );
        // }
        // pairsOfArray(numbers);
        subArrays(numbers);
        

       
    }
}
