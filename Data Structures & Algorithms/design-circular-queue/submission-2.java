
class MyCircularQueue {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node front;
    private Node rear;
    private int size;
    private final int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;
        front = null;
        rear = null;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        Node newNode = new Node(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }

        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }

        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : front.value;
    }

    public int Rear() {
        return isEmpty() ? -1 : rear.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}