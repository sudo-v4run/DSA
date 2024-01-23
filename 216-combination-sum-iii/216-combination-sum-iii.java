class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        f(1,k,n,ans,res);
        
        return res;
    }
    public void f(int start, int k, int sum, ArrayList<Integer> ans,
                   List<List<Integer>> res){
        
        if(sum == 0 && ans.size() == k){
            
            res.add(new ArrayList<>(ans));
            
            return;
        }
        
        if(sum < 0){
            return;
        }
        
        if(ans.size() > k){
            return;
        }
        
        for(int i = start ; i <= 9 ; i++){
            
            ans.add(i);
            
            f(i+1,k,sum-i,ans,res);
            
            ans.remove(ans.size()-1);
        }
    }
}