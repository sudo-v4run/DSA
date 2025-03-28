import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Adjacency List with Min-Heap (PriorityQueue)
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> t : tickets) {
            adj.computeIfAbsent(t.get(0), k -> new PriorityQueue<>()).add(t.get(1));
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", adj, res);
        return res;
    }

    public void dfs(String v, HashMap<String, PriorityQueue<String>> adj, LinkedList<String> res) {
        PriorityQueue<String> neighbors = adj.get(v);

        while (neighbors != null && !neighbors.isEmpty()) {
            String next = neighbors.poll(); // Remove edge directly
            dfs(next, adj, res);
        }
        
        res.addFirst(v); // Add to result in post-order
    }
}
