class WordDictionary {
    
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
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        
        int n = word.length();
        
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
        
        return match(node,0,word);
    }
    public boolean match(TrieNode node, int index, String word){
        int n = word.length();
        
        if(index == n){
            return node.endOfWord;
        }
        
        char cur = word.charAt(index);
        
        if(cur != '.'){
            if(node.containsTrie(cur)){
                TrieNode nextNode = node.nextTrie(cur);
                return match(nextNode,index+1,word);
            }else{
                return false;
            }
        }else{
            for(char ch = 'a' ; ch <= 'z' ; ch++){
                if(node.containsTrie(ch)){
                    TrieNode nextNode = node.nextTrie(ch);
                    if(match(nextNode,index+1,word)){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}