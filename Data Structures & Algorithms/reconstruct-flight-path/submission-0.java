class Solution {
    // Map to store the graph: Departure -> List of Destinations (using ArrayList)
    Map<String, List<String>> graph = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. Build the graph
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new ArrayList<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        // 2. Sort destinations in reverse order for efficient O(1) removal from the end
        for (List<String> destinations : graph.values()) {
            destinations.sort(Collections.reverseOrder());
        }

        // 3. Start Hierholzer's algorithm (DFS) from JFK
        dfs("JFK");
        return itinerary;
    }

    private void dfs(String airport) {
        List<String> destinations = graph.get(airport);
        
        // Visit all neighbors
        while (destinations != null && !destinations.isEmpty()) {
            // Get and remove the last element (lexicographically smallest due to reverse sort)
            String nextAirport = destinations.remove(destinations.size() - 1);
            dfs(nextAirport);
        }
        
        // Add to itinerary in reverse order
        itinerary.addFirst(airport);
    }
}
