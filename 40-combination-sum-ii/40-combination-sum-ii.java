class Solution {
    
    static List<List<Integer>> res;
        
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        f(0,target,candidates,ans);
        
        return res;
    }
    public static void f(int index, int target, int arr[], ArrayList<Integer> ans){
        
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        if(target < 0){
            return;
        }
        
        if(index == arr.length){
            return;
        }
        
        // take
        
        ans.add(arr[index]);
        f(index+1,target-arr[index],arr,ans);
        ans.remove(ans.size()-1);
        
        // notTake
        
        while(index < arr.length-1 && arr[index] == arr[index+1]){
            index++;
        }
        f(index+1,target,arr,ans);
    }
}