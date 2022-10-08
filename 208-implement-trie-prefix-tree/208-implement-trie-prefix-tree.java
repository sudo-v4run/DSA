class Trie {
    TrieNode root;
    class TrieNode{
        TrieNode arr[] = new TrieNode[26];
        boolean isEnd = false;
    }
    public Trie() {
        
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.arr[ch-'a'] == null){
                TrieNode newNode = new TrieNode();
                cur.arr[ch-'a'] = newNode;
            }
            cur = cur.arr[ch-'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.arr[ch-'a'] == null){
                return false;
            }
            cur = cur.arr[ch-'a'];
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
            if(cur.arr[ch-'a'] == null){
                return false;
            }
            cur = cur.arr[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */