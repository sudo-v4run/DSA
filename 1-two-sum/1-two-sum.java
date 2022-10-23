class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int ans[] = new int[2];
        
        
        // O(N) ...
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            if(hm.containsKey(target-nums[i])){
                ans[0] = hm.get(target-nums[i]);
                ans[1] = i;
                break;
            }
            hm.put(nums[i],i);
        }
        return ans;
        
        
        
        
        
        /* O(N.logN) .... This is soultion is only fore booelan return type.
                                    Coz indices' position changes when sorted.*/
        // Using 2 pointers approach....
        
//         Arrays.sort(nums);
//         int s = 0;
//         int e = nums.length-1;
        
//         while(s<e){
//             if(nums[s]+nums[e]==target){
//                 return true;
//             }
//             if(nums[s]+nums[e]<target){
//                 s++;
//             }else{
//                 e--;
//             }
//         }
        
//         return false;
        
        
        
        
        
        
        
         /* O(N.logN) .... This is soultion is only fore booelan return type.
                                    Coz indices' position changes when sorted.*/
        
        // Using Binary Search...
        
//         Arrays.sort(nums);
        
        
//         for(int i = 0 ; i < n ; i++){
//             if(bs(nums,target-nums[i]))
//                 return true;
//         }
//         return false;
        
    }
}