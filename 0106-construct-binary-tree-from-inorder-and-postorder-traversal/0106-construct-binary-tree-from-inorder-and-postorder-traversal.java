
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            hm.put(inorder[i],i);
        }
        
        return f(postorder,inorder,0,n-1,0,n-1,hm);
    }
    public static TreeNode f(int[] post,int[] in, int postS, int postE,
                             int inS, int inE, HashMap<Integer,Integer> hm){
        
        if( postS>postE || inS>inE )
            return null;
        
        TreeNode root = new TreeNode(post[postE]);
        
        int inPos = hm.get(post[postE]);
        int noOfElesOnR = inE - inPos;
        
        root.left = f(post,in,postS,postE-noOfElesOnR-1,inS,inPos-1,hm);
        root.right = f(post,in,postE-noOfElesOnR,postE-1,inPos+1,inE,hm);
        
        return root;
    }
}