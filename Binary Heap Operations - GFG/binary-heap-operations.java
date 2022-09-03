//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            MinHeap h = new MinHeap(a);
            for (int i = 0; i < a; i++) {
                int c = sc.nextInt();
                int n;
                if (c == 1) {
                    n = sc.nextInt();

                    h.insertKey(n);
                }
                if (c == 2) {
                    n = sc.nextInt();
                    h.deleteKey(n);
                }
                if (c == 3) {
                    System.out.print(h.extractMin() + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class MinHeap {
    int[] harr;
    int capacity;
    int n;
    MinHeap(int cap) {
        n = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    //Function to extract minimum value in heap and then to store 
    //next minimum value at first index.
    int extractMin()
    {
       if(n<=0){
           return -1;
       }
       if(n==1){
           n--;
           return harr[0];
       }
       int answer=harr[0];
       harr[0]=harr[n-1];
       n--;
        MinHeapify(0);
       return answer;
    }

    //Function to insert a value in Heap.
    void insertKey(int k) 
    {
        if(n==capacity){
            return;
        }
        n = n+1;
        int i = n-1;
        harr[i] = k;
        
        while(i>0){
            if(harr[parent(i)] > harr[i]){
                int temp = harr[parent(i)];
                harr[parent(i) ] = harr [i];
                harr[i] = temp;
                
                i = parent(i);
            }else{
                return;
            }
        }
        
    }
    void swap(int arr[],int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Function to delete a key at ith index.
    void deleteKey(int i)
    {
        if(i>n-1)
            return;
        
        decreaseKey(i,-1);
        extractMin();
    }

    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) 
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < n && harr[l] < harr[i]) smallest = l;
        if (r < n && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
