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
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        HashMap<String,Integer> hm = new HashMap<>();
        DisjointSet d = new DisjointSet(n);
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < accounts.get(i).size() ; j++){
                String curMail = accounts.get(i).get(j);
                
                if(!hm.containsKey(curMail)){
                    hm.put(curMail,i);
                }else{
                    d.union(i,hm.get(curMail));
                }
            }
        }
        
        ArrayList<ArrayList<String>> combinedAccs = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            combinedAccs.add(new ArrayList<>());            
        }
        
        for(String mail : hm.keySet()){
            int node = d.findParent(hm.get(mail));
            combinedAccs.get(node).add(mail);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            if(combinedAccs.get(i).size()==0){
                continue;
            }
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            Collections.sort(combinedAccs.get(i));
            for(int j = 0 ; j < combinedAccs.get(i).size() ; j++){
                temp.add(combinedAccs.get(i).get(j));
            }
            res.add(temp);
        }
        
        return res;
    }
}