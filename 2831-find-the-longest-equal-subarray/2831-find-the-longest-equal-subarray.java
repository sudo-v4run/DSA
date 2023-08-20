class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        
        int n = nums.size();
        
        int arr[] = new int[n];
        int t = 0;
        
        for(int ele : nums){
            arr[t++] = ele;
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int maxFreq = 0;
        
        int i = 0;
        int j = 0;
        while(j < n){
            hm.put(arr[j],hm.getOrDefault(arr[j],0)+1);
            maxFreq = Math.max(maxFreq,hm.get(arr[j]));
            
            if(j-i+1 - maxFreq <= k){
                j++;
            }else{
                while(j-i+1 - maxFreq > k){
                    hm.put(arr[i],hm.get(arr[i])-1);
                    i++;
                }
                j++;
            }
        }
        
        return maxFreq;
    }
}