
class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    // Pushes element x onto the top of the stack
    public void push(int x) {
        queue.add(x);
        
        // Rotate the queue to bring the new element to the front
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
    }
    
    // Removes the element on the top of the stack and returns it
    public int pop() {
        return queue.poll();
    }
    
    // Gets the top element of the stack
    public int top() {
        return queue.peek();
    }
    
    // Returns true if the stack is empty, false otherwise
    public boolean empty() {
        return queue.isEmpty();
    }
}