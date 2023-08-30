class KthLargest {
    TreeNode root;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums)
        {
            root = add(root, n);
        }
    }
    
    public int add(int val) {
        root = add(root, val);
        return findKthLargest(root);
    }
    
    private int findKthLargest(TreeNode root)
    {
        int count = k;
        TreeNode iter = root;
        
        while (count > 0)
        {
            int rightCount = (iter.right != null ? iter.right.count : 0);
            int leftCount = (iter.left != null ? iter.left.count : 0);
            
            if (count <= rightCount) 
            {
                iter = iter.right;
            }
            else if (count <= (iter.count - leftCount)) break;
            else
            {
                count -= (iter.count - leftCount);
                iter = iter.left;
            }
        }
        
        return iter.val;
    }
     
    private TreeNode add(TreeNode root, int val)
    {
        if (root == null) return new TreeNode(val);
        root.count++;
        
        if (val < root.val) root.left = add(root.left, val);
        if (val > root.val) root.right = add(root.right, val);
        
        return root;
    }
    
    class TreeNode
    {
        int val, count = 1;
        TreeNode left, right;
        public TreeNode(int val)
        {
            this.val = val;
        }
    }
}