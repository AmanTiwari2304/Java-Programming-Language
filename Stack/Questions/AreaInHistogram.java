package Stack.Questions;

import java.util.Stack;

public class AreaInHistogram {

    public static void maxAreaInHistogram(int heights[]){
        Stack<Integer> s = new Stack<>();
        int nextSmallerRight[] = new int[heights.length];
        int maxArea = 0;
        for (int i = heights.length-1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerRight[i] = heights.length;
            } else {
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }
        
        s = new Stack<>();
        int nextSmallerLeft[] = new int[heights.length];
        for (int i = 0; i>= heights.length-1; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }  
        
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmallerRight[i] - nextSmallerLeft[i] -1;
            int currArea = heights[i]*width;
            maxArea = Math.max(maxArea, currArea);      
        }

        System.out.println("Max area in histogram = " + maxArea);
        
    }
    public static void main(String[] args) {
        
        int heights[] = {2,1,5,6,2,3};
        maxAreaInHistogram(heights);
        
    }
}
