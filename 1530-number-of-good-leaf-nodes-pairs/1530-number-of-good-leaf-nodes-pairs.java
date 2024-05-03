
class Solution {
    static int cnt;
    public int countPairs(TreeNode root, int distance) {
        
        cnt = 0;
        
        f(root,distance);
        
        return cnt;
    }
    public ArrayList<Integer> f(TreeNode root, int distance){
        
        if(root == null){
            ArrayList<Integer> res = new ArrayList<>();
            res.add((int)1e7);
            
            return res;
        }
        
        if(root.left == null && root.right == null){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            
            return res;
        }
        
        ArrayList<Integer> left = f(root.left,distance);
        ArrayList<Integer> right = f(root.right,distance);
        
        for(int i = 0 ; i < left.size() ; i++){
            for(int j = 0 ; j < right.size() ; j++){
                
                if(left.get(i)+right.get(j) <= distance){
                    cnt++;
                }
            }
        }
        
        ArrayList<Integer> merged = new ArrayList<>();
        
        for(int i = 0 ; i < left.size() ; i++){
            merged.add(left.get(i)+1);
        }
        for(int i = 0 ; i < right.size() ; i++){
            merged.add(right.get(i)+1);
        }
        
        return merged;
    }
}