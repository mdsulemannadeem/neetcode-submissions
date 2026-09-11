class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Initialize the MinStack
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push an element onto the stack
    public void push(int val) {
        stack.push(val);
        // Push to minStack if it's the new minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop the top element from the stack
    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            // Remove from minStack if it matches the popped value
            if (popped == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    // Get the top element of the stack
    public int top() {
        return stack.peek();
    }

    // Retrieve the minimum element in the stack
    public int getMin() {
        return minStack.peek();
    }}