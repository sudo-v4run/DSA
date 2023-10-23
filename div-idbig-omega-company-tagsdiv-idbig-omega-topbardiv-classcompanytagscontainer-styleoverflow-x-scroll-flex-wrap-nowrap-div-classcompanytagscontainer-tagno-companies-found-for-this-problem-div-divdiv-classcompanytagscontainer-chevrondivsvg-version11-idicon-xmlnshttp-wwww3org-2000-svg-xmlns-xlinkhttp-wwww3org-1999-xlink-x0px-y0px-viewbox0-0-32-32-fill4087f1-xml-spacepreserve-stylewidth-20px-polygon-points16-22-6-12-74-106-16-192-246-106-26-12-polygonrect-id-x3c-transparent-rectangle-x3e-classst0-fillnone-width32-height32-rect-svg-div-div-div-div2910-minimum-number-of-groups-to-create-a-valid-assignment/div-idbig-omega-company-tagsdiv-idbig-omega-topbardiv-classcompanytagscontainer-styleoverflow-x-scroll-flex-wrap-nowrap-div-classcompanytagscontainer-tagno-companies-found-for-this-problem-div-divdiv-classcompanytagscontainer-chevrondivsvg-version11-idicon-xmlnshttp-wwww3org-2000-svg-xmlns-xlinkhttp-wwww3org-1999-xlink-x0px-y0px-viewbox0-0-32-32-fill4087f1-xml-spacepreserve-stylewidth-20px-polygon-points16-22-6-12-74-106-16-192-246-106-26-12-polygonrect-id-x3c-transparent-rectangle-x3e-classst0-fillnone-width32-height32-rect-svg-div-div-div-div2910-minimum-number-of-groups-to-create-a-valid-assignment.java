class Solution {
    public int minGroupsForValidAssignment(int[] arr) {
        
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int minFreq = n+1;
        for(int value : hm.values()){
            minFreq = Math.min(minFreq,value);
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 1 ; i <= minFreq ; i++){
            int x = i;
            int y = i+1;
            int cnt = 0;
            for(int freq : hm.values()){
                int grpsForCurFreq = freq/y;
                int rem = freq%y;
                if(rem == 0){
                    cnt += grpsForCurFreq;
                }else if(grpsForCurFreq >= x-rem){
                    cnt += grpsForCurFreq;
                    cnt++;
                }else{
                    cnt += n+1;
                    // not possible case...i.e. we won't
                    // get answer with cur x and y
                    // worst case answer will n(1 ele in a 
                    // group). So, we add n+1 to ignore 
                    // this case...similar to how we return
                    // Int.MAX in DP Qs when a case is not
                    // valid. We can add Int.MAX also here.
                }
            }
            ans = Math.min(ans,cnt);
        }
        
        return ans;
    }
}