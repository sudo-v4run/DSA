class Solution {
    
    static HashMap<Integer,Integer> hm;
    
    public List<Integer> rightSideView(TreeNode root) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        hm = new HashMap();
        
        f(root,0);
        
        int l =0;
        
        while(true){
            if(!hm.containsKey(l)){
                break;
            }
            res.add(hm.get(l));
            l++;
        }
        
        return res;
    }
    public static void f(TreeNode root,int lvl){
        if(root == null){
            return;
        }
        
        hm.put(lvl,root.val);
        
        f(root.left,lvl+1);
        f(root.right,lvl+1);
    }
}