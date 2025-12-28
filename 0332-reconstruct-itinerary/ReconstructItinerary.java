import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // Build graph
        for (List<String> ticket : tickets) {
            graph
                .computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                .offer(ticket.get(1));
        }

        // Start DFS from JFK
        dfs("JFK");

        return itinerary;
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }

        // Add airport after all outgoing flights are used
        itinerary.addFirst(airport);
    }
}
