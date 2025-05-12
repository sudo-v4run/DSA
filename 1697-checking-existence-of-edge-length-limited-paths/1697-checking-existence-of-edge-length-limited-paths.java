class Solution {
    class DisjointSet{
        int parent[],rank[];
        DisjointSet(int n){
            parent = new int[n];
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
            rank = new int[n];
            Arrays.fill(rank,1);
        }
        int findParent(int u){
            if(parent[u] == u){
                return u;
            }
            
            return parent[u] = findParent(parent[u]);
        }
        void union(int a, int b){
            int parent_a = findParent(a);
            int parent_b = findParent(b);
            
            if(parent_a == parent_b){
                return;
            }
            
            int rank_parent_a = rank[parent_a];
            int rank_parent_b = rank[parent_b];
            
            if(rank_parent_a < rank_parent_b){
                parent[parent_a] = parent_b;
            }else if(rank_parent_a > rank_parent_b){
                parent[parent_b] = parent_a;
            }else{
                parent[parent_b] = parent_a;
                rank[parent_a]++;
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        DisjointSet dsu = new DisjointSet(n+1);
        
        Arrays.sort(edgeList,(a,b)->{return a[2]-b[2];});

        ArrayList<ArrayList<Integer>> q = new ArrayList<>();

        // for(int i = 0 ; i < queries.length ; i++){
        //     q.add(new ArrayList<>());
        // }

        int ind = 0;
        for(int que[] : queries){
            // int u = que[0];
            // int v = que[1];
            // int dist = que[2];
            // int index = ind;

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(que[0]);
            temp.add(que[1]);
            temp.add(que[2]);
            temp.add(ind);

            q.add(temp);

            ind++;
        }

        Collections.sort(q,(a,b)->{return a.get(2)-b.get(2);});
        boolean res[] = new boolean[queries.length];

        int i = 0;
        for(ArrayList<Integer> query : q){
            //int u = query.get(0);
            //int v = query.get(1);
            int limit = query.get(2);

            for( ; i < edgeList.length ; i++){
                int u = edgeList[i][0];
                int v = edgeList[i][1];
                int dist = edgeList[i][2];

                if(dist >= limit){
                    break;
                }

                dsu.union(u,v);
            }

            if(dsu.findParent(query.get(0)) == dsu.findParent(query.get(1))){
                res[query.get(3)] = true;
            }
        }

        return res;
    }
}