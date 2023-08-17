
class Solution {
    static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        int max = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            int first = 0, last = 0;
            int min = q.peek().num;
            for(int i = 0 ; i < sz ; i++){
                Pair pop = q.poll();
                int cur_num = pop.num - min;
                
                if(i == 0){
                    first = cur_num;
                }
                if(i == sz-1){
                    last = cur_num;
                }
                if(pop.node.left != null){
                    q.add(new Pair(pop.node.left,2*cur_num+1));
                }
                if(pop.node.right != null){
                    q.add(new Pair(pop.node.right,2*cur_num+2));
                }
                
            }
            max = Math.max(max,last-first+1);
        }
        
        return max;
    }
}