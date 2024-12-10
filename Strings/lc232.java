import java.util.*;
class lc232  // Implement a Queue using Stacks
{
	Stack<Integer> st1, st2;

    public lc232() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }
        st1.push(x);
    }
    
    public int pop() {
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        return st2.pop();
    }
    
    public int peek() {
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}