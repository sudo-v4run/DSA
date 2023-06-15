class Solution {
    
    static List<List<Integer>> res;
    
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        
        Arrays.sort(arr);       // to avoid duplicates later
        
        res = new ArrayList<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        f(0,arr,ans);
        
        return res;
    }
    public static void f(int i, int arr[], ArrayList<Integer> ans){
        
        if(i == arr.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        // take
        
        ans.add(arr[i]);
        f(i+1,arr,ans);
        ans.remove(ans.size()-1);
        
        // notTake and avoid duplicates...
        
        while(i+1 < arr.length && arr[i] == arr[i+1]){
            i++;
        }
        
        f(i+1,arr,ans);
    }
}