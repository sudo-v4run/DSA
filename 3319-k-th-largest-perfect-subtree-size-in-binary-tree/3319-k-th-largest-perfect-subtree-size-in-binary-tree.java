
class Solution {
    ArrayList<Integer> res;
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        
        res = new ArrayList<>();
        
        f(root);
        
        Collections.sort(res,(a,b)->{
            return b - a;
        });
        
        // for(int x : res){
        //     System.out.println(x);
        // }
        
        if(k > res.size()){
            return -1;
        }
        
        return res.get(k-1);
    }
    public Pair f(TreeNode root){
        
        if(root == null){
            return new Pair(0,0);
        }
        
        Pair left = f(root.left);
        Pair right = f(root.right);
        
        if(left.size == right.size && left.ht == right.ht){
            int newSize = left.size+right.size+1;
            res.add(newSize);
            return new Pair(newSize,Math.max(left.ht,right.ht)+1);
        }
        
        return new Pair(-1,-1);
    }
    
    class Pair{
        int size, ht;
        
        Pair(int size, int ht){
            this.size = size;
            this.ht = ht;
        }
    }
}