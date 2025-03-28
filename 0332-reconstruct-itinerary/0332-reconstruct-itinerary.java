import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> t : tickets) {

            String d = t.get(0);
            String a = t.get(1);

            if(!adj.containsKey(d)){
                adj.put(d, new PriorityQueue<>());
            }

            adj.get(d).add(a);
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", adj, res);
        return res;
    }

    public void dfs(String v, HashMap<String, PriorityQueue<String>> adj, LinkedList<String> res) {

        while (adj.get(v) != null && !adj.get(v).isEmpty()) {
            String next = adj.get(v).poll();
            dfs(next, adj, res);
        }
        
        res.addFirst(v);
    }
}
