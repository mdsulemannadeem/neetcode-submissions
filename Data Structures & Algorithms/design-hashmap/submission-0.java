class Node {
    int key;
    int value;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private static final int BUCKET_SIZE = 769;  
    private ArrayList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new ArrayList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }
    
    private int getHash(int key) {
        return Math.abs(key) % BUCKET_SIZE;
    }
    
    public void put(int key, int value) {
        int index = getHash(key);
        ArrayList<Node> bucket = buckets[index];
        
        // Using a standard loop to search and update
        for (int i = 0; i < bucket.size(); i++) {
            Node node = bucket.get(i);
            if (node.key == key) {
                node.value = value;
                return; 
            }
        }
        
        bucket.add(new Node(key, value));
    }
    
    public int get(int key) {
        int index = getHash(key);
        ArrayList<Node> bucket = buckets[index];
        
        // Using a standard loop to find the value
        for (int i = 0; i < bucket.size(); i++) {
            Node node = bucket.get(i);
            if (node.key == key) {
                return node.value;
            }
        }
        
        return -1; 
    }
    
    public void remove(int key) {
        int index = getHash(key);
        ArrayList<Node> bucket = buckets[index];
        
        // Using a standard loop to find and delete
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.remove(i); 
                return; 
            }
        }
    }
}
