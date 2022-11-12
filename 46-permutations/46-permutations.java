class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        f(nums,hs,res,ans);
        return res;
    }
    public static void f(int arr[] ,HashSet<Integer> hs,
                                List<List<Integer>> res,ArrayList<Integer> ans ){
        
        if(hs.size()==arr.length){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        
        for(int i = 0 ; i < arr.length ; i++){
            if(!hs.contains(arr[i])){
                hs.add(arr[i]);
                ans.add(arr[i]);
                f(arr,hs,res,ans);
                ans.remove(ans.size()-1);
                hs.remove(arr[i]);
            }
        }
        
    }
}