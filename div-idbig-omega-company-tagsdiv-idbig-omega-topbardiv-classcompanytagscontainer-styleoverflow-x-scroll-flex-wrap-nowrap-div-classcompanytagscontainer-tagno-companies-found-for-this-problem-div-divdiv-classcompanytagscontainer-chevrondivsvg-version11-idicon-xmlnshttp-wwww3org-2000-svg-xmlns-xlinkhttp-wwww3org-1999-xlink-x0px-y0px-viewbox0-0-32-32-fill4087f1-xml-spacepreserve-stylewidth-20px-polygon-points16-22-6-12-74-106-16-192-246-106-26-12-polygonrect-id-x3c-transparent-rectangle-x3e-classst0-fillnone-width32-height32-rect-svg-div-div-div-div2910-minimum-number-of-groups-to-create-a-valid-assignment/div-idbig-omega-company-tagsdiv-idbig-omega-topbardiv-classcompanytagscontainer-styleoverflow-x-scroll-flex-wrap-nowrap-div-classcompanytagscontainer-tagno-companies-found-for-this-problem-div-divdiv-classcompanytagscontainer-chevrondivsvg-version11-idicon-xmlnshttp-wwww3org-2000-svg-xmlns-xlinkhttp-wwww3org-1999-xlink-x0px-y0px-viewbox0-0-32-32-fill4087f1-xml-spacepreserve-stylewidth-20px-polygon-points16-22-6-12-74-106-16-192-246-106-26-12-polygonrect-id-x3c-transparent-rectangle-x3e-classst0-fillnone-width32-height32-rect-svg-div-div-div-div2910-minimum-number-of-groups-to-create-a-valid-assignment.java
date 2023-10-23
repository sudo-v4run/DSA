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
                    
                    // we divided cur freq into groups with y eles..
                    // and if rem != 0 means that there are some elements left in last
                    // grp. Now,  in order to make this last group valid, it should
                    // contain atleast x elements. Since, we divided upper grps with
                    // y eles(1 ele extra in all prevgrps), we can give 1 ele from each
                    // grp to the last grp. If there are enough elements that we can 
                    // give to the last grp, then last grp is also valid, thus another
                    // cnt++. If the total count of all those 1 ele contribution
                    // from all the upper/prev grps is deficit, then we can't make the last
                    // grp valid. We have rem no.of eles in the last grp, and to make it
                    // valid there should be atleast x eles in the last grp.
                    // So, how much do we need more?
                    // moreNeeded = x-rem. What is max count of 1 ele 
                    // from all prev grps in total we can give?
                    // It is == grpsForCurFreq(total count of 1 ele
                    // contribution from each grp)...
                    // So, if grpsForCurFreq >= moreNeeded.i.e we have sufficient
                    // no.of prevGrps from which we can contribute an ele to the last
                    // grp to make it valid.
                }else{
                    cnt += n+1;
                    
                    // not possible case...i.e. we won't
                    // get answer with cur x and y.
                    // Worst case answer will n (1 ele in a 
                    // group). So, we add n+1 to ignore 
                    // this case...similar to how we return
                    // Int.MAX in DP Qs when a case is not
                    // valid. We can add Int.MAX here also. But since, it can overflow
                    // the INT range, cnt += n+1 will work fine.
                }
            }
            ans = Math.min(ans,cnt);
        }
        
        return ans;
    }
}