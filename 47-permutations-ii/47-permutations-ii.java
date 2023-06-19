class Solution {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        f(nums,0,res);
        
        return res;
    }
    public static void f(int arr[] , int index, List<List<Integer>> res){
        
        if(index==arr.length){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i : arr){
                ans.add(i);
            }
            res.add(ans);
            return;
        }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = index; i < arr.length ;i++){
            
            if(hs.contains(arr[i])){
                continue;
            }
            hs.add(arr[i]);
            
            swap(arr,i,index);
            f(arr,index+1,res);
            swap(arr,i,index);
        }
        
    }
    public static void swap(int arr[],int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}