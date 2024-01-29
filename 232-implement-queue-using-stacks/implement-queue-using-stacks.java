class MyQueue {
    Queue<Integer> que;
    public MyQueue() {
        que = new LinkedList<>();
    }
    
    public void push(int x) {
        que.add(x);
    }
    
    public int pop() {
        return que.remove();
    }
    
    public int peek() {
        return que.peek();
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */