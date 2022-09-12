//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

  public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    boolean isHeap(Node tree) {
        int n = noOfNodes(tree);
        return checkIsHeap(tree,n,0);
    }
    boolean checkIsHeap(Node root,int n,int i){
        if(root==null){
            return true;
        }
        if(i>=n){
            return false;
        }
        if((root.left!=null && root.data<=root.left.data)||(root.right!=null&&root.data<=root.right.data))
            return false;
        
        return checkIsHeap(root.left,n,2*i+1)&&checkIsHeap(root.right,n,2*i+2);
    }
    int no = 0;
    int noOfNodes(Node root){
        if(root==null){
            return 0;
        }
        
        int leftn = noOfNodes(root.left);
        int rytn = noOfNodes(root.right);
        
        return 1+leftn+rytn;
    }
}