class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();

        if(n == 1){
            res.add(0);
            return res;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
          adj.add(new ArrayList<>());  
        }

        HashMap<Integer,Integer> degree = new HashMap<>();

        for(int e[] : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);

            degree.put(e[0],degree.getOrDefault(e[0],0)+1);
            degree.put(e[1],degree.getOrDefault(e[1],0)+1);
        }

        Queue<Integer> leafs = new LinkedList<>();
        for(int key : degree.keySet()){
            if(degree.get(key) == 1){
                leafs.add(key);
            }
        }

        while(!leafs.isEmpty()){

            if(n <= 2){     // only for this condition, we have to go level wise below
                break;
            }

            int sz = leafs.size();

            for(int i = 0; i < sz; i++){
                int pop = leafs.poll();
                for(int nei : adj.get(pop)){
                    degree.put(nei,degree.get(nei)-1);
                    if(degree.get(nei) == 1){
                        leafs.add(nei);
                    }
                }
                n--;
            }
        }

        while(!leafs.isEmpty()){
            res.add(leafs.poll());
        }

        return res;
    }
}