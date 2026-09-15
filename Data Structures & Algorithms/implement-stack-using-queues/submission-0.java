

class MyStack {
    // Use Deque interface with ArrayDeque implementation
    private Deque<Integer> deque;

    public MyStack() {
        deque = new ArrayDeque<>();
    }
    
    // Pushes element x onto the top of the stack
    public void push(int x) {
        deque.addFirst(x); 
    }
    
    // Removes the element on the top of the stack and returns it
    public int pop() {
        return deque.removeFirst(); // Changed from pollLast() to removeFirst()
    }
    
    // Gets the top element of the stack
    public int top() {
        return deque.peekFirst(); 
    }
    
    // Returns true if the stack is empty, false otherwise
    public boolean empty() {
        return deque.isEmpty(); // Simplified the if-else logic
    }
}
