class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        HashSet<Integer> hs = new HashSet<>();
        
        f(k,n,hs,res);
        
        return res;
    }
    public void f(int k, int sum, HashSet<Integer> hs,
                   List<List<Integer>> res){
        
        if(sum == 0 && hs.size() == k){
            
            boolean isDup = true;
            for(List<Integer> li : res){
                for(int ele : li){
                    if(!hs.contains(ele)){
                        isDup = false;
                        break;
                    }
                }
                if(isDup){
                    return;
                }
                if(!isDup){
                    isDup = true;
                }
            }
            
            ArrayList<Integer> temp = new ArrayList<>();
            for(int ele : hs){
                temp.add(ele);
            }
            res.add(temp);
            
            return;
        }
        
        if(sum < 0){
            return;
        }
        
        if(hs.size() > k){
            return;
        }
        
        for(int i = 1 ; i <= 9 ; i++){
            if(hs.contains(i)){
                continue;
            }
            
            hs.add(i);
            
            f(k,sum-i,hs,res);
            
            hs.remove(i);
        }
    }
}