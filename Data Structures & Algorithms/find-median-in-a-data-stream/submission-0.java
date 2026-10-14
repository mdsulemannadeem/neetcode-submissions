class MedianFinder {
 private PriorityQueue<Integer> maxHeap; // Stores the smaller half
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
       maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    
    }
    
    public void addNum(int num) {
       maxHeap.offer(num);
        
        // Step 2: Balancing step—ensure every element in maxHeap <= every element in minHeap
        minHeap.offer(maxHeap.poll());
        
        // Step 3: Maintain size property—maxHeap can have at most 1 more element than minHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
         if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        
        // If total elements are even, average the tops of both heaps
        // We use 2.0 to force floating-point division
        return (maxHeap.peek() + minHeap.peek()) / 2.0;

    }
}
