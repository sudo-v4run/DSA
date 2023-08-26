
public class Codec {

    public String serialize(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        StringBuilder ans = new StringBuilder();
        
        while(!q.isEmpty()){
            TreeNode pop = q.poll();
            if(pop == null){
                ans.append("N#");
                continue;
            }
            ans.append(String.valueOf(pop.val)+"#");
            q.add(pop.left);
            q.add(pop.right);
        }
        
        return ans.toString();
    }
    public TreeNode deserialize(String data) {
        
        String nodeVals[] = data.split("#");
        
        if(nodeVals[0].equals("N")){
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodeVals[0]));
        q.add(root);
        
        for(int i = 1 ; i < nodeVals.length ; ){
            TreeNode pop = q.poll();
            if(!nodeVals[i].equals("N")){
                pop.left = new TreeNode(Integer.valueOf(nodeVals[i]));
                q.add(pop.left);
            }
            i++;
            
            if(!nodeVals[i].equals("N")){
                pop.right = new TreeNode(Integer.valueOf(nodeVals[i]));
                q.add(pop.right);
            }
            i++;
        }
        
        return root;
    }
}
