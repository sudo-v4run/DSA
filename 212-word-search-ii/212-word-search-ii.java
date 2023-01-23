class Solution {
    
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
    
    public List<String> findWords(char[][] board, String[] words) {
        
        int m = board.length;
        int n = board[0].length;
        
        root = new TrieNode();
        Set<String> res = new HashSet();
        
        for(String word : words){
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(!node.containsTrie(ch)){
                    node.putTrie(ch);
                }
                node = node.nextTrie(ch);
            }
            node.endOfWord = true;
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j <n ; j++){
                f(i,j,"",board,root,res);
            }
        }
        
        List<String> list = new ArrayList<>();
        
        for(String word : res){
            list.add(word);
        }
        
        return list;
    }
    public static void f(int i,int j,String ans, char[][] board, 
                         TrieNode node, Set<String> res){
        
        if(node.endOfWord){
            res.add(ans);
            node.endOfWord = false;
        }
        
        int m = board.length, n = board[0].length;
        
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]=='#'){
            return;
        }
        
        char temp = board[i][j];
        
        if(!node.containsTrie(temp)){
            return;
        }
        
        board[i][j] = '#';
        
        f(i-1,j,ans+temp,board,node.nextTrie(temp),res);
        f(i,j-1,ans+temp,board,node.nextTrie(temp),res);
        f(i+1,j,ans+temp,board,node.nextTrie(temp),res);
        f(i,j+1,ans+temp,board,node.nextTrie(temp),res);
        
        board[i][j] = temp;
    }
}