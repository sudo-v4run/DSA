class Solution {
    class Trie{
        Trie[] links = new Trie[2];
        
        public boolean containsTrie(int bit){
            return links[bit] != null;
        }
        
        public void putTrie(int bit){
            links[bit] = new Trie();
        }
        
        public Trie nextTrie(int bit){
            return links[bit];
        }
        
    }
    
    Trie root;
    
    Solution(){
        root = new Trie();
    }
    
    public void insert(int num){
        Trie node = root;
        
        for(int i = 31; i >= 0 ; i--){
            int ithBit = ((1<<i) & num) == 0 ? 0 : 1;
            if(!node.containsTrie(ithBit)){
                node.putTrie(ithBit);
            }
            node = node.nextTrie(ithBit);
        }
    }
    
    public int getMax(int num){
        Trie node = root;
        int max = 0;
        
        for(int i = 31 ; i >= 0 ; i--){
            int ithBit = ((1<<i) & num) == 0 ? 0 : 1;
            if(node.containsTrie(1-ithBit)){
                max = max | (1<<i) ;
                node = node.nextTrie(1-ithBit);
            }else{
                node = node.nextTrie(ithBit);
            }
        }
        
        return max;
    }
    
    public int[] maximizeXor(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        
        ArrayList<ArrayList<Integer>> oQ = new ArrayList<ArrayList<Integer>>();
        
        int q = queries.length;
        
        for(int i = 0 ; i < q ; i++){
            
            ArrayList<Integer> temp = new ArrayList<>();
            
            int xi = queries[i][0];
            int mi = queries[i][1];
            int qInd = i;
            
            temp.add(mi);
            temp.add(xi);
            temp.add(qInd);
            
            oQ.add(temp);
            
        }
        
        Collections.sort(oQ, (a,b) -> { return a.get(0)-b.get(0); } );
        
        int res[] = new int[q];
        int ind = 0;
        
        for(int i = 0;i<q;i++) {
             while(ind<arr.length && arr[ind] <= oQ.get(i).get(0)) {
                 insert(arr[ind]); 
                 ind++; 
             }
             int queryInd = oQ.get(i).get(2);
            
             if(ind!=0) res[queryInd]=getMax(oQ.get(i).get(1));
             else res[queryInd] = -1; 
         }
        
        return res;
    }
}