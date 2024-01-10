class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        
        for(int ele : nums1){
            hs1.add(ele);
        }
        for(int ele : nums2){
            hs2.add(ele);
        }
        
        int uniqueInArr1 = 0;
        int uniqueInArr2 = 0;
        int both = 0;
        
        for(int ele : hs1){
            if(!hs2.contains(ele)){
                uniqueInArr1++;
            }else{
                both++;
            }
        }
        for(int ele : hs2){
            if(!hs1.contains(ele)){
                uniqueInArr2++;
            }
        }
        
        uniqueInArr1 = Math.min(uniqueInArr1,n/2);
        uniqueInArr2 = Math.min(uniqueInArr2,n/2);
        
        if(uniqueInArr1 < n/2){
            int rem = (n/2) - uniqueInArr1;
            int has = Math.min(both,rem);
            
            uniqueInArr1 += has;
            both -= has;
        }
        if(uniqueInArr2 < n/2){
            int rem = (n/2) - uniqueInArr2;
            int has = Math.min(both,rem);
            
            uniqueInArr2 += has;
            both -= has;
        }
        
        return uniqueInArr1+uniqueInArr2;
    }
}