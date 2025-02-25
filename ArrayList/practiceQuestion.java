package ArrayList;

import java.util.ArrayList;

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
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(4);
        nums.add(3);

        System.out.println(isMonotonic(nums));
    }
}
