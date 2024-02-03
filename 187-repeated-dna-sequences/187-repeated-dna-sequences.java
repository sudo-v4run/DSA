class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        int n = s.length();
        
        HashSet<String> vis = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        
        for(int i = 0 ; i <= n-10 ; i++){
            String cur = s.substring(i,i+10);
            
            if(vis.contains(cur)){
                ans.add(cur);
            }
            vis.add(cur);
        }
        
        List<String> res = new ArrayList<>();
        for(String str : ans){
            res.add(str);
        }
        
        return res;
    }
}