class Trie {
    
    class TrieNode{
        TrieNode[] links = new TrieNode[26];
        boolean endOfWord = false;
        
        boolean containsTrie(char ch){
            return links[ch-'a']!=null;
        }
        
        void putTrie(char ch){
            links[ch-'a'] = new TrieNode();
        }
        
        TrieNode nextTrie(char ch){
            return links[ch-'a'];
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        
        for(char ch : word.toCharArray()){
            if(!node.containsTrie(ch)){
                node.putTrie(ch);
            }
            node = node.nextTrie(ch);
        }
        node.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        
        for(char ch : word.toCharArray()){
            if(!node.containsTrie(ch)){
                return false;
            }
            node = node.nextTrie(ch);
        }
        
        return node.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        
        for(char ch : prefix.toCharArray()){
            if(!node.containsTrie(ch)){
                return false;
            }
            node = node.nextTrie(ch);
        }
        
        return true;
    }
}