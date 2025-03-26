package Stack.Assignment;

import java.util.Stack;

public class minStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            s.push(val);
            min.push(val);
        }else{
            s.push(val);
            if(min.peek()<val){
                min.push(min.peek());
            }else{
                min.push(val);
            }
        }
    }
    
    public void pop() {
        s.pop();
        min.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        
    }
}
