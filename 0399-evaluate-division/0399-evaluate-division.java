class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, ArrayList<Node>> hm = new HashMap<>();

        int index = 0;
        for(List<String> eq : equations){
            String ai = eq.get(0);
            String bi = eq.get(1);

            if(!hm.containsKey(ai)){
                hm.put(ai, new ArrayList<>());
            }
            if(!hm.containsKey(bi)){
                hm.put(bi, new ArrayList<>());
            }

            hm.get(ai).add(new Node(bi, values[index]));

            hm.get(bi).add(new Node(ai, (double)(1d/values[index])));

            index++;
        }

        int n = queries.size();

        double res[] = new double[n];

        index = 0;
        for(List<String> q : queries){
            String cj = q.get(0);
            String dj = q.get(1);

            HashSet<String> vis = new HashSet<>();

            double cur = -1.00000;
            if(hm.containsKey(cj)){

                cur = dfs(cj, 1, dj, hm, vis);
                if(cur > 0){
                    res[index] = cur;
                    index++;
                    continue;
                }
            }

            if(cur < 0){
                res[index] = -1;
                index++;
            }
        }

        return res;
    }
    public static double dfs(String cur, double prod, String dest, 
            HashMap<String, ArrayList<Node>> hm, HashSet<String> vis){

        if(cur.equals(dest)){
            return prod;
        }

        if(vis.contains(cur)){
            return -1;
        }
        vis.add(cur);

        double ans = -1;

        if(hm.get(cur) == null){
            return -1;
        }

        for(Node nei : hm.get(cur)){
        
            ans = dfs(nei.v, prod*nei.w, dest, hm, vis);

            if(ans > 0){
                return ans;
            }
        }

        vis.remove(cur);
        return ans;
    }
    class Node{
        String v;
        double w;
        Node(String v, double w){
            this.v = v;
            this.w = w;
        }
    }
}