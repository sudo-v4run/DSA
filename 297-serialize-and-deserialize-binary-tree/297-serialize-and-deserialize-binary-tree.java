public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode pop = q.poll();
            if(pop==null){
                str.append("#,");
                continue;
            }
            String toAdd = String.valueOf(pop.val)+',';
            str.append(toAdd);
            q.add(pop.left);
            q.add(pop.right);
        }
        
        return str.toString();
    }
    public TreeNode deserialize(String data) {
   
        String nodeVals[] = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        
        if(nodeVals[0].equals("#")){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
        q.add(root);
        
        for(int i = 1 ; i < nodeVals.length ; ){
            TreeNode pop = q.poll();
            
            if(!nodeVals[i].equals("#")){
                pop.left = new TreeNode(Integer.valueOf(nodeVals[i]));
                q.add(pop.left);
            }
            i++;
            if(!nodeVals[i].equals("#")){
                pop.right = new TreeNode(Integer.valueOf(nodeVals[i]));
                q.add(pop.right);
            }
            i++;
        }
        
        return root;
    }
}