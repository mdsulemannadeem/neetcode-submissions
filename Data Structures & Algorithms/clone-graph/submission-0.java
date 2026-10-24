class Solution {
    // HashMap to map original nodes to their cloned counterparts
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        // If the node has already been cloned, return its clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Create a deep copy of the current node (without neighbors yet)
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // Store it in the map before traversing neighbors to handle cycles
        visited.put(node, cloneNode);
        
        // Recursively clone all neighbors and add them to the cloned node's list
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return cloneNode;
    }
}
