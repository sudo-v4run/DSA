//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node firstr = reverse(first);
        Node secondr = reverse(second);
        int carry = 0;
        Node ansHead = null;
        while(firstr!=null||secondr!=null||carry!=0){
            int sum = carry;
            if(firstr!=null){
                sum+=firstr.data;
                firstr=firstr.next;
            }else{
                sum+=0;
            }
            
            if(secondr!=null){
                sum+=secondr.data;
                secondr=secondr.next;
            }else{
                sum+=0;
            }
            
            int last = sum%10;
            carry = sum/10;
            Node lastN = new Node(last);
            if(ansHead==null){
                ansHead = lastN;
            }else{
                Node newHead = lastN;
                newHead.next = ansHead;
                ansHead = newHead;
            }
        }
        
        return ansHead;
    }
    static Node reverse(Node head){
        Node cur = head;
        Node prev = null;
        Node temp = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
}