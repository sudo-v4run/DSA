
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            hm.put(inorder[i],i);
        }
        
        return f(postorder,inorder,0,n-1,0,n-1,hm);
    }
    public static TreeNode f(int[] pre,int[] in, int preS, int preE,
                             int inS, int inE, HashMap<Integer,Integer> hm){
        
        if( preS>preE || inS>inE )
            return null;
        
        TreeNode root = new TreeNode(pre[preE]);
        
        int inPos = hm.get(pre[preE]);
        int noOfElesOnR = inE - inPos;
        
        root.left = f(pre,in,preS,preE-noOfElesOnR-1,inS,inPos-1,hm);
        root.right = f(pre,in,preE-noOfElesOnR,preE-1,inPos+1,inE,hm);
        
        return root;
    }
}