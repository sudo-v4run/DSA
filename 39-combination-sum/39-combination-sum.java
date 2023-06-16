class Solution {
    
    static List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        int n = candidates.length;
        res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        f(0,candidates,target,ans);
        
        return res;
    }
    public static void f(int i,int arr[],int target,ArrayList<Integer> ans){
        
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        if(target < 0){
            return;
        }
        
        if(i == arr.length){
            return;
        }
        
        ans.add(arr[i]);
        
        f(i,arr,target-arr[i],ans);
        
        ans.remove(ans.size()-1);
        
        f(i+1,arr,target,ans);
    }
}