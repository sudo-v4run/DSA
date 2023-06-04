class Solution {
    
    static int ans = -1;
    static int k = -1;
    
    public int kthSmallest(TreeNode root, int K) {
        
        // TC - O(N) ... SC - O(N) ...
        
//         k = K;
        
//         inOrder(root);
        
//         return ans;
        
        
        // Morris Traversal... TC -> O(N) ... SC -> O(1)...
        
        TreeNode cur = root;
        
        int cnt = 0;
        
        while(cur != null){
            if(cur.left==null){
                cnt++;
                if(cnt==K){
                    return cur.val;
                }
                cur = cur.right;
            }else{
                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = cur;
                    cur = cur.left;
                }else{
                    temp.right = null;
                    cnt++;
                    if(cnt==K){
                        return cur.val;
                    }
                    cur = cur.right;
                }
            }
        }
        
        return -1;
    }
    
    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        
        inOrder(root.left);
        
        k--;
        
        if(k==0){
            ans = root.val;
            return;
        }
        
        inOrder(root.right);
    }
}