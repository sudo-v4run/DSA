//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] keys = sc.nextLine().split(" ");

            TrieNode root = new TrieNode();
            for (int i = 0; i < n; i++) {
                insert(root, keys[i]);
            }
            String abc = sc.nextLine();
            if (search(root, abc))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };

    
// } Driver Code Ends

static void insert(TrieNode root, String key) 
{
    TrieNode cur = root;
    for(char ch : key.toCharArray()){
        if(cur.children[ch-'a']==null){
            TrieNode newNode = new TrieNode();
            cur.children[ch-'a'] = newNode;
        }
        cur = cur.children[ch-'a'];
    }
    cur.isEndOfWord = true;
}

static boolean search(TrieNode root, String key)
{
    TrieNode cur = root;
    for(char ch : key.toCharArray()){
        if(cur.children[ch-'a'] == null){
            return false;
        }
        cur = cur.children[ch-'a'];
    }
    return cur.isEndOfWord;
}


//{ Driver Code Starts.
}
// } Driver Code Ends