class LFUCache {
    class Node {
        int key, value, frequency;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; // Initial frequency is always 1
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }
    }

    private final int capacity;
    private int minFrequency;
    private final HashMap<Integer, Node> cacheMap;
    private final HashMap<Integer, DoublyLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cacheMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (capacity == 0 || !cacheMap.containsKey(key)) return -1;
        
        Node node = cacheMap.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        // Scenario 1: Key already exists -> Update value and its frequency
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        // Scenario 2: Cache is full -> Evict the LFU (or LRU if tie) item
        if (cacheMap.size() == capacity) {
            DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);
            Node evictedNode = minFreqList.removeLast();
            if (evictedNode != null) {
                cacheMap.remove(evictedNode.key);
            }
        }

        // Scenario 3: Insert completely new node
        Node newNode = new Node(key, value);
        cacheMap.put(key, newNode);
        
        // A brand new item always sets the baseline minimum frequency to 1
        minFrequency = 1;
        frequencyMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(newNode);
    }

    private void updateFrequency(Node node) {
        int oldFreq = node.frequency;
        DoublyLinkedList oldList = frequencyMap.get(oldFreq);
        oldList.remove(node);

        // If the cleared list belonged to the minFrequency tier and is now empty, increment the system floor
        if (oldFreq == minFrequency && oldList.size == 0) {
            minFrequency++;
        }

        node.frequency++;
        frequencyMap.computeIfAbsent(node.frequency, k -> new DoublyLinkedList()).addFirst(node);
    }
}
