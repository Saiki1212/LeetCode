class MyStack {
    Queue <Integer> q1 ; 
    Queue <Integer> q2 ; 
    int top;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        top = x;
        q1.offer(x);
    }
    
    public int pop() {
        while(q1.size() > 1) {
            top = q1.poll();
            q2.offer(top);
        }
        int val = q1.poll();
        while(!q2.isEmpty()) q1.offer(q2.poll());
        return val;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}