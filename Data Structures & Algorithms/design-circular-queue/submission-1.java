class MyCircularQueue {

    private LinkedList<Integer> list;
    private int capacity;

    public MyCircularQueue(int k) {
        list = new LinkedList<>();
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        list.addLast(value);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        list.removeFirst();
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : list.getFirst();
    }

    public int Rear() {
        return isEmpty() ? -1 : list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == capacity;
    }
}