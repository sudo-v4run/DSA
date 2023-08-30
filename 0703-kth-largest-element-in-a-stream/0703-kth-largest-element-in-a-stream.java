class KthLargest {
    
    PriorityQueue<Integer> pq;
    
    int k;

    public KthLargest(int K, int[] arr) {
        k = K;
        pq = new PriorityQueue<>();
        
        int n = arr.length;
        
        for(int i = 0 ; i < k && i < n ; i++){
            pq.add(arr[i]);
        }
        
        for(int i = k ; i < n ; i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
    }
    
    public int add(int val) {
        
        if(pq.size() < k){
            pq.add(val);
        }else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        
        return pq.peek();
    }
}


// Using BST....

// class KthLargest {
//     TreeNode root;
//     int k;
//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         for (int num: nums) root = add(root, num);
//     }

//     public int add(int val) {
//         root = add(root, val);
//         return findKthLargest();
//     }

//     private TreeNode add(TreeNode root, int val) {
//         if (root == null) return new TreeNode(val);
//         root.count++;
//         if (val < root.val) root.left = add(root.left, val);
//         else root.right = add(root.right, val);

//         return root;
//     }

//     public int findKthLargest() {
//         int count = k;
//         TreeNode walker = root;

//         while (count > 0) {
//             int pos = 1 + (walker.right != null ? walker.right.count : 0);
//             if (count == pos) break;
//             if (count > pos) {
//                 count -= pos;
//                 walker = walker.left;
//             } else if (count < pos)
//                 walker = walker.right;
//         }
//         return walker.val;
//     }

//     class TreeNode {
//         int val, count = 1;
//         TreeNode left, right;
//         TreeNode(int v) { val = v; }
//     }
// }