class Solution {
    
    class Trie{
        Trie[] links = new Trie[2];
        
        boolean containsTrie(int bit){
            return links[bit]!=null;
        }
        
        void putTrie(int bit){
            links[bit] = new Trie();
        }
        
        Trie nextTrie(int bit){
            return links[bit];
        }
    }
    
    Trie root;
    
    Solution(){
        root = new Trie();
    }
    
    public void insert(int num){
        Trie node = root;
        
        for(int i = 31 ; i >=0 ; i--){
            int bit = ((1<<i)&num) !=0 ? 1 : 0;
            if(!node.containsTrie(bit)){
                node.putTrie(bit);
            }
            node = node.nextTrie(bit);
        }
    }
    
    public int getMax(int num){
        Trie node = root;
        int max = 0;
        
        for(int i = 31; i>= 0 ; i--){
            int bit = ((1<<i)&num) != 0 ? 1 : 0;
            if(node.containsTrie(1-bit)){
                max = max | (1<<i);
                node = node.nextTrie(1-bit);
            }else{
                node = node.nextTrie(bit);
            }
        }
        
        return max;
    }
    
    
    public int findMaximumXOR(int[] nums) {
        
        for(int i : nums){
            insert(i);
        }
        
        int max = 0;
        
        for(int i : nums){
            max = Math.max(max,getMax(i));
        }
        
        return max;
    }
}