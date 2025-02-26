package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class practiceQuestion {
    public static boolean  isMonotonic(ArrayList<Integer> nums){
        if (nums.size() == 1)  return true;      
        boolean up = nums.get(0) <= nums.get(nums.size()-1);
        if (up) {
            for (int i = 1; i < nums.size(); i++) {
                if(nums.get(i)<nums.get(i-1)) return false;
            }
        } else {
            for (int i = 1; i < nums.size(); i++) {
                if(nums.get(i)>nums.get(i-1)) return false;
            }
        }
        return true;
    }

    public static void lonelyNumbers(ArrayList<Integer> nums){
        ArrayList<Integer> lonelyNum = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (nums.get(i) == nums.get(j) || nums.get(i)+1 == nums.get(j) || nums.get(i)-1 == nums.get(j)) {
                    lonelyNum.add(nums.get(i));
                    lonelyNum.add(nums.get(j));
                }
            }
        }
        nums.removeAll(lonelyNum);
        System.out.println("Lonely numbers are "+nums);
    }

    public static void lonelyNumberOptimized(ArrayList<Integer> nums){
        ArrayList<Integer> lonelyNum = new ArrayList<>();
        Collections.sort(nums);
        if(nums.size() == 1) {
            System.out.println("Lonely numbers are "+nums);
        }   

        //Case 1
        for(int i=0; i<=nums.size()-2; i++){
            if(nums.get(i) == nums.get(i+1)){
                lonelyNum.add(nums.get(i));
            }
        }
        //Case 2
        for(int i=0; i<=nums.size()-2; i++){
            if(nums.get(i)+1 == nums.get(i+1)){
                lonelyNum.add(nums.get(i));
                lonelyNum.add(nums.get(i+1));
            }
        }
        nums.removeAll(lonelyNum);
        System.out.println("Lonely numbers are "+nums);
    }
    
    public static void mostFrequentNum(ArrayList<Integer> nums,int key){
        
        int maxCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            int count = 0 ;
            for (int j = 0; j < nums.size(); j++) {
                if (nums.get(i) == nums.get(j)) {
                    count += 1;
                }
                if (maxCount < count) {
                    maxCount = count;
                    key = nums.get(i);
                }
            }
        }

        System.out.println( "There are " + maxCount + " occurance of " + key);
    }


    public static void main(String[] args) {
        // ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(1);
        // nums.add(2);
        // nums.add(4);
        // nums.add(3);

        // System.out.println(isMonotonic(nums));

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 16, 6, 5, 1, 5, 5,  8, 6, 7, 3, 5, 9, 13));
        // lonelyNumbers(nums);
        // lonelyNumberOptimized(nums);
        int key = 10;
        mostFrequentNum(nums,key);


    }
}
