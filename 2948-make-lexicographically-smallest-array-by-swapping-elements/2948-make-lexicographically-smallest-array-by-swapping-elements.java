class Solution {
    class Pair{
        int val,ind;
        Pair(int val, int ind){
            this.val = val;
            this.ind = ind;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;
        
        Pair arr[] = new Pair[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = new Pair(nums[i],i);
        }
        
        Arrays.sort(arr,(a,b)->{
            return a.val - b.val;
        });
        
        for(int i = 0 ; i < n ; i++){
            
            ArrayList<Integer> inds = new ArrayList<>();
            ArrayList<Integer> vals = new ArrayList<>();
            
            while(i+1 < n && arr[i+1].val - arr[i].val <= limit){
                inds.add(arr[i].ind);
                vals.add(arr[i].val);
                
                i++;
            }
            inds.add(arr[i].ind);
            vals.add(arr[i].val);
            
            Collections.sort(inds);
            Collections.sort(vals);
            
            for(int j = 0 ; j < inds.size() ; j++){
                nums[inds.get(j)] = vals.get(j);
            }
        }
        
        return nums;
    }
}