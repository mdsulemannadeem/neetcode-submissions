class LRUCache { 
    class Node { 
        int key, value; 
        Node prev, next; 
        Node(int key, int value) { 
            this.key = key; 
            this.value = value; 
        } 
    } 

    private int capacity; 
    private HashMap<Integer, Node> map = new HashMap<>(); 
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0); 

    public LRUCache(int capacity) { 
        this.capacity = capacity; 
        head.next = tail; 
        tail.prev = head; 
    } 

    public int get(int key) { 
        if (!map.containsKey(key)) return -1; 
        
        Node node = map.get(key); 
        remove(node); 
        insert(node); 
        return node.value; 
    } 

    public void put(int key, int value) { 
        // Bug Fix: If key exists, remove the old node entirely before inserting the updated one
        if (map.containsKey(key)) {
            remove(map.get(key)); 
        }
        
        // Bug Fix: Only evict if it's a brand NEW key and we are at capacity
        if (map.size() == capacity) { 
            remove(tail.prev); 
        } 
        
        // Insert the fresh/updated node
        Node newNode = new Node(key, value); 
        insert(newNode); 
    } 

    private void remove(Node node) { 
        map.remove(node.key); 
        node.prev.next = node.next; 
        node.next.prev = node.prev; 
    } 

    private void insert(Node node) { 
        map.put(node.key, node); 
        node.next = head.next; 
        node.prev = head; 
        head.next.prev = node; 
        head.next = node; 
    } 
}