class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int ele : nums){
            arr.add(ele);
        }
        
        Collections.sort(arr,(a,b)->{
            if(Math.abs(a-x) < Math.abs(b-x)){
                return -1;
            }else if(Math.abs(a-x) == Math.abs(b-x) && a < b){
                return -1;
            }
            return 1;
        });
        
        List<Integer> res = new ArrayList<>();
        
        for(int ele : arr){
            res.add(ele);
            if(res.size() == k){
                break;
            }
        }
        
        Collections.sort(res);
        
        return res;
    }
}