package Stack.Questions;

import java.util.Stack;

public class RemoveConsecutive {
    public static int[] removeEle(int[] arr){
        Stack <Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty() || s.peek() != arr[i] ) {
                s.push(arr[i]);
            }else{
                if (s.peek() == arr[i]) {
                    if (arr[i] != arr[i+1] || i == arr.length-1) {
                        s.pop();
                    }
                }
            }
        }
        int res[] = new int[s.size()];
        int m = res.length;
        for (int i = m-1; i>=0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 10, 10, 10, 4 , 5, 5, 5 , 2, 7, 7 , 6};
        int result[] = removeEle(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
