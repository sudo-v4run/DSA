// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // Node res = head;
        // Node ans = head;
        // int cnt0=0,cnt1=0,cnt2=0;
        // while(head!=null){
        //     if(head.data==0){
        //         cnt0++;
        //     }else if(head.data==1){
        //         cnt1++;
        //     }else{
        //         cnt2++;
        //     }
        //     head = head.next;
        // }
        // while(cnt0--!=0){
        //     res.data = 0;
        //     res = res.next;
        // }
        // while(cnt1--!=0){
        //     res.data = 1;
        //     res = res.next;
        // }
        // while(cnt2--!=0){
        //     res.data = 2;
        //     res = res.next;
        // }
        
        // return ans;
        
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        
        Node zero = zeroD,one = oneD, two = twoD;
        
        Node curr = head;
        
        while(curr!=null){
            if(curr.data==0){
                zero.next = curr;
                zero = zero.next;
                curr = curr.next;
            }else if(curr.data==1){
                one.next = curr;
                one = one.next;
                curr = curr.next;
            }else if(curr.data==2){
                two.next = curr;
                two = two.next;
                curr = curr.next;
            }
        }
        
        zero.next = (oneD.next!=null)? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;
        
        head = zeroD.next;
        
        return head;
    }
}


