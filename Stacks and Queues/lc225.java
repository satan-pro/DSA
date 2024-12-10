import java.util.*;
class lc225  // Implement Stack using Queue
{
	Queue<Integer> q;

    public lc225() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        int i = q.size();
        while(i>1)
        {
            q.add(q.poll());
            i--;
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}